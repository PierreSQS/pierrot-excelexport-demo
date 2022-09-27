package pierrot.excelexport.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import pierrot.excelexport.exception.ExcelTemplateNotReadException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class ExcelView extends AbstractXlsxView {
    private static final String EXCEL_TEMPLATE = "templates/excel/Excel_Template.xlsx";
    private static final String FILE_URL =
            " file:/target/excel-export-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/templates/excel/Excel_Template.xlsx";

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ExcelView.class);

    private Resource resource;

    public ExcelView() {
        this.resource = new ClassPathResource(EXCEL_TEMPLATE);
    }

    @Override
    protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {

        log.debug("the resource canonical: {}",resource.getClass().getCanonicalName());


        XSSFWorkbook xssfWorkbook;

        log.info("########### loading the Excel Template {} ###########",EXCEL_TEMPLATE);

        try(InputStream inputStream = resource.getClass().getClassLoader().getResourceAsStream(FILE_URL)) {
            log.info("########### loading the Excel Template {} ###########",
                    resource.getFile().getPath());
            log.info("########### the Excel Template URL {} ###########",resource.getURL());

            xssfWorkbook = new XSSFWorkbook(inputStream);
            log.info("---------- create XSSFWorkbook from excel template {} !!!! ---------- ",
                    resource.getFilename());
        } catch (IOException e) {
            log.error("********* Error by reading the Excel Template !!!! ********** ");
            throw new ExcelTemplateNotReadException(e.getMessage());
        }

        log.info("########### filling the Excel-Template {} ###########", resource.getFilename());

        return xssfWorkbook;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment;fileName=InvoiceData.xlsx");

    }

}
