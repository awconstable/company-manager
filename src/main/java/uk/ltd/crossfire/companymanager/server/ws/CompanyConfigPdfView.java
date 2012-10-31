package uk.ltd.crossfire.companymanager.server.ws;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CompanyConfigPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<String> parts = (List<String>) model.get("content");

		for(String part:parts){
			document.add(new Paragraph(part));
		}

		document.addAuthor("Crossfire Ltd");

		document.addCreationDate();

		document.addCreator("Crossfire Ltd");

		document.addTitle("INVOICE XYZ");

	}

}
