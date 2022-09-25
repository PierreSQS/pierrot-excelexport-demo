package pierrot.excelexport.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class ExcelBuilder extends AbstractXlsxView {

    private final ResourceLoader resourceLoader;

    public ExcelBuilder(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {

        return super.createWorkbook(model, request);
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

}
