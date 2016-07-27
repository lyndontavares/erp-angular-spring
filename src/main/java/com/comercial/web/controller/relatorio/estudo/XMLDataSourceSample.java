package com.comercial.web.controller.relatorio.estudo;

import java.io.FileNotFoundException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class XMLDataSourceSample
{

    public static void main(String[] args) throws FileNotFoundException, JRException
    {

        JasperReport jasperReport = null;

        String recordPath = "/employee/person";

        String xmlFileName = "Address.xml";

        String path = "D:/JasperTemplates/";

        JasperPrint jasperPrint = null;

        // Provide path for your JRXML template.

        String templateName = path + "ReportXML.jrxml";

        // Provide path for your final pdf file.

        String destinationFile = path + "ReportXML.pdf";

        // Compiling the template.

        jasperReport = JasperCompileManager.compileReport(templateName);

        // Sending a parameter with the logged in user name as value

        HashMap<String, Object> parameters = new HashMap<String, Object>();

        // Creating the datasource

        JRXmlDataSource jrxmlds = new JRXmlDataSource(path + xmlFileName, recordPath);

        // Filling the report template with data

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrxmlds);

        JasperViewer.viewReport(jasperPrint);

        // Exporting it to an PDF

        JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);

    }

}
