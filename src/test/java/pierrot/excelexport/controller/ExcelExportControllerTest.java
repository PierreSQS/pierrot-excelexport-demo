package pierrot.excelexport.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pierrot.excelexport.excel.ExcelView;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ExcelExportController.class)
class ExcelExportControllerTest {

    @MockBean
    ExcelView excelViewMock;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void downloadExcel() throws Exception {
        mockMvc.perform(get("/excel/download"))
                .andExpect(status().isOk())
//May produce NPE. lived in code for documentation purposes!!!
//                .andExpect(result -> result.getModelAndView().getView())
                .andExpect(view().name(is(nullValue())))
                .andDo(print());
    }
}