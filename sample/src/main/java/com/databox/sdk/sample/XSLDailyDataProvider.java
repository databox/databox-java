package com.databox.sdk.sample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.sdk.daily.impl.DailyDataProvider;
import com.databox.sdk.kpi.KPI;

/**
 *
 * @author Uros Majeric
 *
 */
public class XSLDailyDataProvider extends DailyDataProvider {
	static final Logger logger = LoggerFactory.getLogger(XSLDailyDataProvider.class);

	private final String _fileName;

	public XSLDailyDataProvider(String fileName) {
		_fileName = fileName;
	}

	@Override
	public Collection<KPI> getKPIs() {
		/* Lazy load data */
		if (this.data == null || this.data.isEmpty()) {
			try {
				read();
			} catch (IOException e) {
				logger.error(e.getLocalizedMessage(), e);
			}
		}
		return this.data;
	}

	public void read() throws IOException {
		InputStream res = XSLDailyDataProvider.class.getClassLoader().getResourceAsStream(_fileName);

		/* Get the workbook instance for XLS file */
		XSSFWorkbook workbook = new XSSFWorkbook(res);

		/* Get first sheet from the workbook */
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		/* skip first row (titles) */
		rowIterator.next();

		/* Iterate through each rows from first sheet */
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Date date = row.getCell(0).getDateCellValue();

			/* Get the value from the cell and add a KPI for it for matching date */
			double movingTime = row.getCell(2).getNumericCellValue();
			addKPI("moving_time", date, movingTime);

			double distance = row.getCell(3).getNumericCellValue();
			addKPI("distance", date, distance);

			double avgSpeed = row.getCell(5).getNumericCellValue();
			addKPI("average_speed", date, avgSpeed);

			double maxSpeed = row.getCell(6).getNumericCellValue();
			addKPI("max_speed", date, maxSpeed);
		}
	}
}
