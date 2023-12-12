package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    protected String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList;
    private StringBuilder sb;

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        if (stringList != null) {
            stringArrayList = new LinkedList<>(stringList);
            stringArrayList.forEach(i -> {
                if(i != null){
                    System.out.println(i.hashCode());
                }
                else {
                    System.out.println("Null element encountered");
                }
            });
        }

    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
         sb = new StringBuilder();
       if (stringList != null){
           stringArrayList.forEach(s -> sb.append(s).append(" "));
           processorName = sb.toString();
           return sb.toString();
       }
       return "";

    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        if (this.informationScanner == null) {
            throw new IllegalStateException("Scanner has not been initialized");
        }
        sb = new StringBuilder();
        try{
            informationScanner = new Scanner(file);

            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            informationScanner.close();
        }

        processorVersion = sb.toString();
    }
}
