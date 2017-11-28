package project;

/**
 * @author 20075681.KevinPower
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable
{
    protected DataLink<E> header = null;
    private int size;

    /**
     * Create a new SingleLinkedList
     */
    public LinkedList()
    {
        //create the head with a null data
        header = new DataLink<E>(null);
        size = 0; //the header doesn't count
    }

    /**
     * Add a data to the end of the list
     */
    public void add(E data)
    {
        DataLink<E> prevLink = null;
        //create a new link and append it to the end of the chain
        if (size == 0)
        {
            prevLink = header;
        }
        else
        {
            //find the last link
            prevLink = findLink(size-1);
        }
        DataLink<E> newLink = new DataLink<E>(data, prevLink);
        //increment the size
        size++;
    }


    public void addAtIndex(int index, E data)
    {


        //can actually add at size since it would be the
        //tail DataLink
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        DataLink<E> prevLink = null;
        //create a new link and append it to the end of the chain


        //hashing the index from the input to place in the list
        if (index == 0)
        {
            prevLink = header;
        }
        else
        {
            //find the link at index and it's next link
            //to insert in the middle
            prevLink = findLink(index - 1);
        }
        prevLink.nextDataLink = new DataLink<E>(data, prevLink);

        //increment the size
        size++;
    }
  /*  public void addAtIndexS(int index, E data)
    {
        Movie newData  = (Movie) data;

        //can actually add at size since it would be the
        //tail DataLink
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        DataLink<E> prevLink = null;
        //create a new link and append it to the end of the chain

        int key = index%size;      //hashing the index from the input to place in the list
        LinkedList<Movie> listAtIndex = MovieList.hashlist.get(key);
        listAtIndex.add(newData);

        if (key == 0)
        {

            listAtIndex.add(newData);
        }
        else
        {
            //find the link at index and it's next link
            //to insert in the middle
            prevLink = findLink(key - 1);
        }

        MovieList.hashlist.header.data.add(newMovie);
        prevLink.
        prevLink.nextDataLink = new DataLink<E>(data, prevLink);

        //increment the size
        size++;
    }*/





    /**
     * Remove data from the chain
     */
    public void remove(E data)
    {
        DataLink<E> theLink = header.nextDataLink;
        DataLink<E> prevLink = header;

        if (theLink.data.equals(data))
        {
            //remove the first link
            header.nextDataLink = theLink.nextDataLink;
            theLink = null;
            size--;
        }
        else
        {
            boolean modified = false;
            for (int i = 1; (i <= size && !modified); i++)
            {
                //move to the link to get
                prevLink = theLink;
                theLink = theLink.nextDataLink;
                if (theLink.data.equals(data))
                {
                    prevLink.nextDataLink = theLink.nextDataLink;
                    theLink = null;
                    size--;
                    modified = true;
                }
            }
        }
        return;
    }

    /**
     * Remove link from chain by index
     */
    public void remove(int index)
    {
        CheckValidIndex(index);
        DataLink<E> prevLink = header;
        boolean modified = false;
        for (int i = 0; (i < size && !modified); i++)
        {
            DataLink<E> nextLink = prevLink.nextDataLink;
            if (i == index)
            {
                //this is the link to remove
                prevLink.nextDataLink = nextLink.nextDataLink;
                nextLink = null;
                size--;
                modified = true;
            }
            prevLink = nextLink;
        }
    }

    /**
     * Get the data from the list at index
     */
    public E get(int index)
    {
        //make sure the index is valid
        CheckValidIndex(index);
        DataLink<E> theLink = findLink(index);
        if (theLink != null)
        {
            return theLink.data;
        }
        return null;
    }

    /**
     * Get the data from the list at index and hash index for list size 50
     */
    public E getHash(int index)
    {
        int hash = index%50;
        //make sure the index is valid
        CheckValidIndex(hash);
        DataLink<E> theLink = findLink(hash);
        if (theLink != null)
        {
            return theLink.data;
        }
        return null;
    }

    /**
     * Find the index of the first matching link
     */
    public int findIndex(E data)
    {
        if (size == 0) return -1;
        DataLink<E> theLink = header.nextDataLink;
        if (theLink.data.equals(data)) return 0;
        for (int i = 1; i < size; i++)
        {
            theLink = theLink.nextDataLink;
            //determine if the next link is the one to remove
            if (theLink.data.equals(data))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Get a link from the chain by index.
     */
    protected DataLink<E> findLink(int index)
    {
        CheckValidIndex(index);
        if (size <= 0) {return null;}

        DataLink<E> theLink = header.nextDataLink;
        if (index == 0)
        {
            return theLink;
        }
        else
        {
            for (int i = 1; i < index; i++)
            {
                //move to the link to get
                theLink = theLink.nextDataLink;
            }
            //we are now at the link
            return theLink;
        }
    }

    /**
     * Make sure an index is valid
     */
    private void CheckValidIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                    Integer.toString(index));
        }
    }

    /**
     * DataLink Stores data and links to the next DataLink.
     */
    protected class DataLink<E>
    {
        private int index;
        protected E data;				  		//the data
        protected DataLink<E> nextDataLink;   //the next link in the chain


        /**
         * Create a single data link.
         */
        public DataLink(E theData)
        {
            int index;
            data = theData;
            nextDataLink = null;
        }

        /**
         * Create a new link and point to a next link.
         */
        public DataLink(E theData, DataLink<E> previousLink)
     {
            data = theData;
            nextDataLink = previousLink.nextDataLink;
            previousLink.nextDataLink = this;
        }
    }


    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    public Iterator iterator(int index)
    {
        return new LinkedListIterator(index);
    }



    private class LinkedListIterator<E> implements Iterator
    {
        private DataLink<E> currentLink;
        private DataLink<E> previousLink;
        private int currentIndex;
        private int prevIndex;
        private final int BAD_INDEX = -1;

        public LinkedListIterator()
        {
            this(0);
        }

        public LinkedListIterator(int index)
        {
            CheckValidIndex(index);
            currentLink = (DataLink<E>)LinkedList.this.header.nextDataLink;
            //set the current Index and prevIndex and currentLink
            if (index > 0)
            {
                //move to index
                for (int i = 1; i <= index; i++)
                {
                    currentLink = currentLink.nextDataLink;
                }
            }
            currentIndex = index;
            prevIndex = BAD_INDEX;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            this.prevIndex = currentIndex;
            currentIndex++;
            previousLink = currentLink;
            currentLink = currentLink.nextDataLink;
            return previousLink.data;
        }

        @Override
        public void remove()
        {
            CheckValidState();
            //need to remove the link we just passed over
            LinkedList.this.remove(prevIndex);
            previousLink = null;
            currentIndex--;
            prevIndex = BAD_INDEX;
        }

        private void CheckValidState()
        {
            if (prevIndex == BAD_INDEX)
            {
                throw new IllegalStateException("Must move next before calling remove");
            }
        }
    }
}