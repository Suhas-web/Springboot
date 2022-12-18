import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JasperMain {
    public static void main(String[] args) {
        try{
            String filePath = "C:\\Users\\HP\\Desktop\\Projects\\spring security\\jasper\\src\\main\\resources\\report.jrxml";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("studentName", "John");

            Student student1 = new Student(1L,"Prateek", "Purohit", "Happy Street", "Delhi");
            Student student2 = new Student(2L,"Arif", "Mohammad", "Happy Street", "Gulbarga");
            List<Student> list = new ArrayList<>();
            list.add(student1);
            list.add(student2);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\HP\\Desktop\\Projects\\spring security\\jasper\\src\\main\\resources\\firstReport.pdf");

            System.out.println("ReportCreated");
        } catch (Exception e){
            System.out.println("Exception creating report: " + e.getMessage());
        }
    }
}
