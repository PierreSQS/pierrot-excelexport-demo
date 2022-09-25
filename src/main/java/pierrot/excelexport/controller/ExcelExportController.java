package pierrot.excelexport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pierrot.excelexport.excel.ExcelView;

@Controller
@RequestMapping("excel/download")
public class ExcelExportController {

    private final ExcelView excelBuilder;

    public ExcelExportController(ExcelView excelBuilder) {
        this.excelBuilder = excelBuilder;
    }

    @GetMapping
    public ModelAndView downloadExcel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(excelBuilder);
        return modelAndView;
    }


}
