package scv;

public class ExecuteCsvFile {
    public static void main(String[] args) {
        GenerateCsvFile generateCsvFile = new GenerateCsvFile();
        generateCsvFile.generateCsv("OurFunction", -1 * Math.PI, Math.PI, Math.PI / 100, 0.01);
        //generateCsvFile.generateCsv("OurFunction", - Math.PI / 2, Math.PI, Math.PI/2, 0.01);

    }
}
