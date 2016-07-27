package com.comercial.infra.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.autenticacao.Funcionalidade;
import com.comercial.model.autenticacao.Permissao;
import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.autenticacao.enums.UsuarioSituacao;
import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.Configuracao;
import com.comercial.model.repository.ConfiguracaoRepository;
import com.comercial.model.repository.FuncionalidadeRepository;
import com.comercial.model.repository.PermissaoRepository;
import com.comercial.model.repository.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonView;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@RestController
public class Autorizacao
{

    @Autowired
    private FuncionalidadeRepository funcionalidadeRepository;
    
    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private  ConfiguracaoRepository configuracaoRepository;

    @RequestMapping("/whoami")
    public String whoAmI(HttpServletRequest request)
    {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null)
        {
            ipAddress = "R: " + request.getRemoteAddr();
        }
        return ipAddress;
    }

    @RequestMapping(value = "/autenticarUsuarioFuncionalidade", method = RequestMethod.POST)
    public Iterable<Funcionalidade> autenticaUsuarioFuncionalidade(HttpServletRequest request,
            @RequestBody Usuario pessoa)
    {
        return funcionalidadeRepository.findAll();
    }

    @RequestMapping(value = "/autenticarUsuario", method = RequestMethod.POST)
    public boolean autenticaUsuario(HttpServletRequest request, @RequestBody LoginRequest user)
    {

        return usuarioAutorizado(new Usuario(user.login, user.senha));
    }

    @RequestMapping(value = "/autenticarToken", method = RequestMethod.POST)
    @JsonView(View.class)
    public LoginResponse autenticaUsuarioRetornaToken(HttpServletRequest request,
            @RequestBody LoginRequest usuario) throws IOException, ServletException
    {
        Usuario usuarioEncontrado = usuarioRepository.findBySituacaoAndLoginIgnoreCase( UsuarioSituacao.ATIVO , usuario.login);

        if (usuarioEncontrado != null &&
                usuario.senha.equals(usuarioEncontrado.getSenha()))
        {
            try
            {
                Usuario user = usuarioEncontrado;
                
                Iterable<Permissao> permissao = permissaoRepository.findByUsuarioId(user.getId()) ;
                
                Configuracao configuracao = configuracaoRepository.findOne(1L);
                
                String token =  
                        Jwts.builder()
                        .setSubject(usuarioEncontrado.getNome())
                        .claim("roles", usuarioEncontrado.getAdmin().toString()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "lyndontavares").compact();
                
                
                return new LoginResponse(token,user,permissao,configuracao);
            }
            catch (final SignatureException e)
            {
                throw new ServletException("Token Inválido.");
            }
        }
        else
            throw new ServletException("Usuario não autorizado");
    }
 
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Boolean role(@PathVariable final String role,
            final HttpServletRequest request) throws ServletException
    {
        final Claims claims = (Claims) request.getAttribute("claims");
        List<String> list = (List<String>) claims.get("roles");
        return list.contains(role);
    }

    private boolean usuarioAutorizado(Usuario usuario)
    {
        Usuario p = usuarioRepository.findBySituacaoAndLoginIgnoreCase(UsuarioSituacao.ATIVO,usuario.getNome());
        return (p != null) && usuario.getSenha().equals(p.getSenha());
    }

    private static class LoginRequest
    {
        public String login;
        public String senha;
    }

    @SuppressWarnings("unused")
    private static class LoginResponse
    {
        public String token;
        
        public Configuracao configuracao;

        public Usuario user;

        public List<String> permissao;

        public LoginResponse(final String token, Usuario user, Iterable<Permissao> permissoes, Configuracao configuracao)
        {
            this.token = token;
            this.user = user;
            
            this.permissao= new ArrayList<>();
            for (Permissao p : permissoes)
            {
              this.permissao.add(p.getFuncionalidade().getDescricao());  
            }
            
            this.configuracao = configuracao;
            
        }
    }
}
