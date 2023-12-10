package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected String ProcessorVersion;
    private Integer valueofCheap;
    private Scanner informationscanner;
   private static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationscanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public String getProcessorVersion() {
        return ProcessorVersion;
    }

    public void setProcessorVersion(String processorVersion) {
        ProcessorVersion = processorVersion;
    }

    public Integer getValueofCheap() {
        return valueofCheap;
    }

    public void setValueofCheap(Integer valueofCheap) {
        this.valueofCheap = valueofCheap;
    }

    public Scanner getInformationscanner() {
        return informationscanner;
    }

    public void setInformationscanner(Scanner informationscanner) {
        this.informationscanner = informationscanner;
    }

    public static LinkedList<String> getStringArrayList() {
        return stringArrayList;
    }

    public static void setStringArrayList(LinkedList<String> stringArrayList) {
        LocalProcessor.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName+=stringList.get(i)+' ';
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
            informationscanner = new Scanner(file);
            while (informationscanner.hasNext()) {
                ProcessorVersion+= informationscanner.nextLine();
            }

    }
}
