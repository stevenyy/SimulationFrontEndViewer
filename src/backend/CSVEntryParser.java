package backend;

/**
 * CURRENTLY NOT USED
 * @author siyangwang
 *
 * @param <E>
 */
public interface CSVEntryParser<E> {
    
        public E parseEntry(String... data);
        
}