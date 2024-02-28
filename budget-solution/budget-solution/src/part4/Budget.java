package part4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import part4.exceptions.InvalidUserInputException;
import part4.records.ExpenseRecord;
import part4.records.IncomeRecord;
import part4.records.Record;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Budget {

    private String title;
    private ArrayList<Record> records = new ArrayList<>();


    public Budget(String title) {
        this.title = title;
    }

    public void addRecord(Record record) {
        records.add(record);
        System.out.println("Record added successfully!");
        System.out.println();
    }

    public void addIncomeRecord(IncomeRecord incomeRecord) {
        records.add(incomeRecord);
        System.out.println("Income added successfully!");
        System.out.println();
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord) {
        records.add(expenseRecord);
        System.out.println("Expense added successfully!");
        System.out.println();
    }

    public void viewBalance() {
        System.out.println();
        System.out.printf("Your current balance is: %.2f€%n", getBalance());
        System.out.println();
    }

    private ArrayList<ExpenseRecord> getExpenseRecords() {
        ArrayList<ExpenseRecord> expenseRecords = new ArrayList<>();
        for (Record record : records) {
            if (record instanceof ExpenseRecord expenseRecord) {
                expenseRecords.add(expenseRecord);
            }
        }
        return expenseRecords;
    }

    private ArrayList<IncomeRecord> getIncomeRecords() {
        ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();
        for (Record record : records) {
            if (record instanceof IncomeRecord expenseRecord) {
                incomeRecords.add(expenseRecord);
            }
        }
        return incomeRecords;
    }

    public void viewRecords() {
        System.out.println();
        for (Record r : records) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void viewExpenses() {
        System.out.println();
        for (Record r : getExpenseRecords()) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void viewIncomes() {
        System.out.println();
        for (Record r : getIncomeRecords()) {
            System.out.println(r);
        }
        System.out.println();
    }

    private void viewAllRecords() {
        System.out.println();
        for (Record r : records) {
            System.out.println(r.toString());
        }
        System.out.println();
    }

    private Record getRecordById(Scanner scanner) {
        int recordIndex = records.indexOf(new Record(Integer.parseInt(scanner.nextLine())));
        if (recordIndex == -1) {
            return null;
        }
        return records.get(recordIndex);
    }

    public void editRecordById(Scanner scanner) throws InvalidUserInputException {
        viewAllRecords();
        System.out.println("Enter record ID you want to edit:");
        Record recordToEdit = getRecordById(scanner);
        recordToEdit.editRecord(scanner);
    }

    public void replaceRecordById(Scanner scanner) throws InvalidUserInputException {
        viewAllRecords();
        System.out.println("Enter record ID you want to replace:");
        int indexToReplace = records.indexOf(new Record(Integer.parseInt(scanner.nextLine())));
        if (indexToReplace == -1) {
            System.out.println("No record found");
            return;
        }
        records.set(indexToReplace, new Record(scanner));
    }

    public void deleteRecordById(Scanner scanner) {
        viewAllRecords();
        System.out.println("Enter record ID you want to delete:");
        if (records.remove(new Record(Integer.parseInt(scanner.nextLine())))) {
            System.out.println("Record deleted successfully!");
        } else {
            System.out.println("Failed to delete record");
        }
    }


    private double getBalance() {
        double balance = 0.0;
        for (Record r : records) {
            if (r instanceof ExpenseRecord) {
                balance -= r.getAmount();
            }
            if (r instanceof IncomeRecord) {
                balance += r.getAmount();
            }
        }
        return balance;
    }

    public void loadDataFromFile(Scanner scanner) throws InvalidUserInputException {
//        HashMap<Integer, File> fileMap = getDataFilesAvailable();
        File fileToRead = new File("budget.csv");
        ArrayList<Record> recordsFromFile = readFile(fileToRead);
        if (recordsFromFile != null){
            this.records = recordsFromFile;
        }
    }

    private ArrayList<Record> readFile(File file){
        ArrayList<Record> recordsFromFile = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            recordsFromFile = new ArrayList<>();
            String line;
            br.readLine(); // skip headers line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                switch (fields[1]){
                    case "I" -> recordsFromFile.add(new IncomeRecord(fields));
                    case "E" -> recordsFromFile.add(new ExpenseRecord(fields));
                    case null, default -> recordsFromFile.add(new Record(fields));
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return recordsFromFile;
    }

    private File selectFileToRead(HashMap<Integer, File> fileMap, Scanner scanner) throws InvalidUserInputException {
        try {
            System.out.println("Select file ID:");
            Integer fileId = Integer.parseInt(scanner.nextLine());
            return fileMap.get(fileId);
        } catch (Exception e){
            throw new InvalidUserInputException("Please correctly select file ID from the list", "Integer", "fileId");
        }
    }

    private HashMap<Integer,File> getDataFilesAvailable(){
        HashMap<Integer, File> fileMap = new HashMap<>();
        File[] dataFiles = new File("src/part4/data").listFiles();

        System.out.println();
        System.out.println("DATA FILES AVAILABLE:");
        for (int i = 0; i < dataFiles.length; i++) {
            System.out.printf("[%d] - %s%n", i, dataFiles[i].getName());
            fileMap.put(i, dataFiles[i]);
        }
        System.out.println();

        return fileMap;
    }

    public void saveDataToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("budget.csv"))) {
            writeCSVHeaders(bw);
            writeData(bw);
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String generateDataFilePath() {
        DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String timeStampToSave = timeStampFormatter.format(LocalDateTime.now());
        String budgetTitleToSave = this.title.replace(" ", "").toLowerCase();
        return String.format("src/part4/data/%s_%s.csv", timeStampToSave, budgetTitleToSave);
    }

    private void writeData(BufferedWriter bw) throws IOException {
        for (Record r: records){
            bw.write(r.toCSV());
        }
    }

    private void writeCSVHeaders(BufferedWriter bw) throws IOException {
        bw.write("ID,TYPE,AMOUNT,CURRENCY,DESCRIPTION,PAYMENT_METHOD,INCOME_CATEGORY\n");
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void saveDataToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File("budget.json"), records);
    }

    public void loadDataFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        this.records = objectMapper.readValue(new File("budget.json"), new TypeReference<ArrayList<Record>>() {});
    }
}
