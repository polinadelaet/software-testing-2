package scv;

import au.com.bytecode.opencsv.CSVWriter;
import function.*;
import function.system.LogFunction;
import function.system.SystemFunctions;
import function.system.TrigonometricFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateCsvFile {
    private final Sin sin;
    private final Cos cos;
    private final Ln ln;
    private final Log log;
    private final LogFunction logFunction;
    private final TrigonometricFunction trigonometricFunction;

    public GenerateCsvFile() {
        this.sin = new Sin();
        this.cos = new Cos(sin);
        this.ln = new Ln();
        this.log = new Log(ln);
        this.logFunction = new LogFunction(ln, log);
        this.trigonometricFunction = new TrigonometricFunction(cos);
    }

    public void generateCsv(String functionName, double startX, double endX, double step, double eps) {
        switch (functionName) {
            case "Sin": {
                List<String[]> data = new ArrayList<>();
                for (double i = startX; i <= endX; i += step) {
                    data.add(new String[]{String.valueOf(i), String.valueOf(sin.sin(i, eps))});
                }
                write(data);
                break;
            }
            case "Cos": {
                List<String[]> data = new ArrayList<>();
                for (double i = startX; i <= endX; i += step) {
                    data.add(new String[]{String.valueOf(i), String.valueOf(cos.cos(i, eps))});
                }
                write(data);
                break;
            }
            case "Ln": {
                List<String[]> data = new ArrayList<>();
                for (double i = startX; i <= endX; i += step) {
                    data.add(new String[]{String.valueOf(i), String.valueOf(ln.ln(i, eps))});
                }
                write(data);
                break;
            }
            case "OurFunction": {
                SystemFunctions function = new SystemFunctions(trigonometricFunction, logFunction);
                List<String[]> data = new ArrayList<>();
                for (double i = startX; i <= endX; i += step) {
                    data.add(new String[]{String.valueOf(i), String.valueOf(function.calculate(i, eps))});
                }
                write(data);
                break;

            }
        }

    }

    public void generateCsv(String className, double startX, double endX, double step, double foundation, double eps) {
        if (className.equals("Log")) {
            List<String[]> data = new ArrayList<>();
            for (double i = startX; i <= endX; i += step) {
                data.add(new String[]{String.valueOf(i), String.valueOf(log.log(foundation, i, eps))});
            }
            write(data);
        }
    }

    private void write(List<String[]> data) {
        try {
            String csv = "report.csv";
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            data.forEach(writer::writeNext);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
