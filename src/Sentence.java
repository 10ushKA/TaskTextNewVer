import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Sentence extends Text{
    // определить что является границами предложения и ввести переменную типо sentence*
    public static final String SENTENCE_SPLIT_REGEX = "[.?!]";//Или по split() границы предложения
    String sentence;
    sentence = textFile.split(SENTENCE_SPLIT_REGEX);
    LinkedList<String> sentences = new LinkedList<>();
    sentences.add(sentence);

    //определяем/инициализируем поля/структуру ЛинкедЛиста состоящий из sentences
//вопрос: как обратиться к полю LinkedLista , как вот например мы пишем в массиве array[i] и тут типа sentences[i], только в формате ЛинкедЛиста
    //и вот этот [i]тый элемент - предложение, ограниченное
//да, есть метод get(), но там задается определенный номер элемента, а нам нужен любой аля  i-тый элемент

    public void findSntncWithLngstWrd() throws FileNotFoundException {
        String longestWord  = null;
        String currentW;
        String sentenceWthLngstWrd = null;

//        File(){
//           this.textFile
//        }
// унаследовать поле/уже созданный textFile


        Scanner scanner = new Scanner(textFile);

        while(scanner.hasNext()){
            currentW = scanner.next();
            if(currentW.length() > longestWord.length()){
                longestWord = currentW;
            }

            if(sentenceWthLngstWrd.contains(longestWord)){//вместо sentenceWthLngstWrd написать ту самую переменную sentence*, определенную ранее
                System.out.println("Sentence with longest word is: " + "\" " + sentenceWthLngstWrd + "\" ");
            }
        }

        //описание условий которые будут выводить то самое предложение содержащее longestWord
    }


}
