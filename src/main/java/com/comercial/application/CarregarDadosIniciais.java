package com.comercial.application;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.model.autenticacao.Funcionalidade;
import com.comercial.model.autenticacao.Permissao;
import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.autenticacao.enums.UsuarioSituacao;
import com.comercial.model.autenticacao.enums.UsuarioTipo;
import com.comercial.model.commons.Cidade;
import com.comercial.model.commons.Configuracao;
import com.comercial.model.commons.Contato;
import com.comercial.model.commons.Empresa;
import com.comercial.model.commons.Filial;
import com.comercial.model.commons.Pais;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.Role;
import com.comercial.model.commons.ServidorEmail;
import com.comercial.model.commons.enums.ContatoTipo;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.commons.enums.PessoaRole;
import com.comercial.model.commons.enums.PessoaSituacao;
import com.comercial.model.commons.enums.Sexo;
import com.comercial.model.commons.enums.SimNao;
import com.comercial.model.commons.enums.TipoPessoa;
import com.comercial.model.commons.enums.TipoProfile;
import com.comercial.model.repository.ArtefatoRepository;
import com.comercial.model.repository.CidadeRepository;
import com.comercial.model.repository.ConfiguracaoRepository;
import com.comercial.model.repository.ContatoRepository;
import com.comercial.model.repository.FilialRepository;
import com.comercial.model.repository.FuncionalidadeRepository;
import com.comercial.model.repository.PaisRepository;
import com.comercial.model.repository.PermissaoRepository;
import com.comercial.model.repository.PessoaRepository;
import com.comercial.model.repository.RoleRepository;
import com.comercial.model.repository.UsuarioRepository;
import com.comercial.model.sqldinamico.Artefato;

@Service

public class CarregarDadosIniciais
{

    @Autowired
    private PessoaRepository repoPessoa;

    @Autowired
    private ContatoRepository repoContato;

    @Autowired
    private UsuarioRepository repoUsuario;

    @Autowired
    private PermissaoRepository repoPermissao;

    @Autowired
    private FuncionalidadeRepository repoFuncionalidade;

    @Autowired
    private ConfiguracaoRepository repoConfig;

    @Autowired
    private CidadeRepository repoCidade;

    @Autowired
    private FilialRepository repoFilial;

    @Autowired
    private RoleRepository repoRole;
    
    @Autowired
    private ArtefatoRepository repoArtefato;
    
    @Autowired
    private PaisRepository repoPais;

    public void init()
    {

        if (true)
        {

            Configuracao conf = new Configuracao();
            conf.setId(1);
            conf.setEmpresa(new Empresa("Empresa XYZ", "Endereco XYZ", "9999-9999", "email@email.com", "88888888-88"));
            conf.setMoedaPrincipal(Moeda.DOLAR);
            conf.setProfile(TipoProfile.ATIVO);
            conf.setChaveRegistroDaAplicacao("IUTZY-POIQZA-LZAOP-POQQQ-PLOKA");
            
            conf.setServidorEmail(new ServidorEmail("smtp.googlemail.com",   465 , "com3rcial3rp@gmail.com", "com3rcial3rp@gmail.com", "xpto2016."));
            
            repoConfig.save(conf);

            repoFilial.save(new Filial(1, "MATRIZ"));

            repoCidade.save(new Cidade(1, "FOZ DO IGUACU"));

            for (long i = 1; i <= 10; i++)
            {

                Pessoa p = new Pessoa();
                p.setId(i);
                p.setNome("pessoa-" + i);
                p.setDocumento("doc-"+i);
                p.setSituacao(PessoaSituacao.ATIVA);
                p.setSexo(Sexo.MASCULINO);
                p.setTipoPessoa(TipoPessoa.FISICA);
                p.setTelefone("9999-9999");
                p.setCredito(SimNao.NAO);
                p.setEmail("email@gmail.com");
                p.setCidade(new Cidade(1, null));
                p.setCadastro(new Date());
                p.setNascimento(new DateTime().minusYears(20).toDate());

                repoPessoa.save(p);

                Contato c = new Contato(0, "Contato-" + i, ContatoTipo.AMIGO, "9999-000" + i, "email@com", p);
                repoContato.save(c);

                Usuario usu = new Usuario("Lyndon Tavares - " + i, "a" + i, "123", UsuarioSituacao.ATIVO,
                        UsuarioTipo.USER, p);
                repoUsuario.save(usu);

                Role r1 = new Role(0, p, PessoaRole.CLIENTE);
                repoRole.save(r1);
                Role r2 = new Role(0, p, PessoaRole.FORNECEDOR);
                repoRole.save(r2);
                Role r3 = new Role(0, p, PessoaRole.FUNCIONARIO);
                repoRole.save(r3);

            }

            Usuario u = new Usuario();
            Funcionalidade f = new Funcionalidade();
            Permissao p = new Permissao();

            u.setId(1);
            p.setUsuario(u);
            p.setFuncionalidade(f);

            f.setId(11);
            f.setDescricao("pessoa.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(12);
            f.setDescricao("pessoa.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(13);
            f.setDescricao("pessoa.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(14);
            f.setDescricao("pessoa.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(21);
            f.setDescricao("fatura.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(22);
            f.setDescricao("fatura.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(23);
            f.setDescricao("fatura.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(24);
            f.setDescricao("fatura.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(31);
            f.setDescricao("unidade.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(32);
            f.setDescricao("unidade.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(33);
            f.setDescricao("unidade.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(34);
            f.setDescricao("unidade.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(41);
            f.setDescricao("conta.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(42);
            f.setDescricao("conta.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(43);
            f.setDescricao("conta.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(44);
            f.setDescricao("conta.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            


            
            p.setId(0);
            f.setId(51);
            f.setDescricao("titulo.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(52);
            f.setDescricao("titulo.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(53);
            f.setDescricao("titulo.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(54);
            f.setDescricao("titulo.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(61);
            f.setDescricao("catalogo.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(62);
            f.setDescricao("catalogo.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(63);
            f.setDescricao("catalogo.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(64);
            f.setDescricao("catalogo.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(71);
            f.setDescricao("pedido.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(72);
            f.setDescricao("pedido.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(73);
            f.setDescricao("pedido.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(74);
            f.setDescricao("pedido.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
           
            p.setId(0);
            f.setId(81);
            f.setDescricao("planoconta.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(82);
            f.setDescricao("planoconta.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);
            f.setId(83);
            f.setDescricao("planoconta.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(84);
            f.setDescricao("planoconta.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(91);
            f.setDescricao("filial.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(92);
            f.setDescricao("filial.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);
            f.setId(93);
            f.setDescricao("filial.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(94);
            f.setDescricao("filial.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(101);
            f.setDescricao("grupo.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(102);
            f.setDescricao("grupo.insert");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);
            f.setId(103);
            f.setDescricao("grupo.update");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(104);
            f.setDescricao("grupo.delete");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);

            
            p.setId(0);
            f.setId(111);
            f.setDescricao("financeiro.select");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
 
            p.setId(0);
            f.setId(10005);
            f.setDescricao("gerenciar.relatorio");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(10000);
            f.setDescricao("gerenciar.grafico");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            f.setId(10001);
            f.setDescricao("gerenciar.usuario");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(10002);
            f.setDescricao("gerenciar.configuracao");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            
            p.setId(0);
            f.setId(10003);
            f.setDescricao("gerenciar.aprovacao");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);

            f.setId(10004);
            f.setDescricao("gerenciar.auditoria");
            repoFuncionalidade.save(f);
            repoPermissao.save(p);
            p.setId(0);

            
            Artefato art1 = new Artefato(1,"Pessoas por Categoria","select r.pessoa_role, count( p.id ) from pessoa p, role r where r.pessoa_id = p.id group by  r.pessoa_role");
            repoArtefato.save(art1);
           
            Artefato art2 = new Artefato(2,"Pessoa por Tipo","select p.tipo_pessoa, count( p.id ) from pessoa p  group by p.tipo_pessoa" );
            repoArtefato.save(art2);
              
            
            Pais p1 = new Pais(0,"Brasil","BRA",55,Moeda.REAL);
            repoPais.save(p1);
            Pais p2 = new Pais(0,"Paraguai","PAR",595,Moeda.GUARANI);
            repoPais.save(p2);           
            Pais p3 = new Pais(0,"Argentina","ARG",54,Moeda.PESO);
            repoPais.save(p3);           
            Pais p4 = new Pais(0,"Estados Unido","EUA",1,Moeda.DOLAR);
            repoPais.save(p4);           
        }

    }
 

}
