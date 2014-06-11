package backend;

public interface CSVEntryParser<E> {
    
        public E parseEntry(String... data);
        
}