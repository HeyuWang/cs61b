public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d =  new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            d.addLast(c);
        }
        return d;
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        /*Character head,tail;
        while(d.size() > 1){
            head = d.removeFirst();
            tail = d.removeLast();
            if(head != tail)
                return false;
        }
        return true;*/
        return palindromeHelper(d);
    }

    public boolean palindromeHelper(Deque<Character> d){
        if(d.size() <= 1)
            return true;
        Character head = d.removeFirst();
        Character tail = d.removeLast();
        if(head == tail)
            return palindromeHelper(d);
        else
            return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        return palindromeHelper(d,cc);
    }

    public boolean palindromeHelper(Deque<Character> d, CharacterComparator cc){
        if(d.size() <= 1)
            return true;
        Character head = d.removeFirst();
        Character tail = d.removeLast();
        if(cc.equalChars(head,tail))
            return palindromeHelper(d,cc);
        else
            return false;
    }
}
