import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Word extends Text{
    public static final String WORD_SPLIT_REGEX = "";//Или по split() границы предложения
    String word;
    word = textFile.split(WORD_SPLIT_REGEX);
    LinkedList<String> words = new LinkedList<>();
    words.add(word);


    public int countEqualWrds(File textFile) throws FileNotFoundException {// в скобках в качестве принемающих параметров кооелкцию, хранящий текст
        int wordCounter = 0;
        String equalWord;

//        Scanner scanner = new Scanner(textFile);
//
//        while(scanner.hasNext()){
//            equalWord = scanner.next();
//            if(equalWord.equals(word)){
//            equalWord = word;
//            }
//        }

        //возможно через Паттерн и Мэтчер и/ мтедом equals

        //ИЛИ ИСПОЛЬЗОВАТЬ REGEX ПАТТЕРНЫ  pATTERN  И Matcher, + т.к. они интерфейсный, поля по умолчанию private static final


        for(int i = 0; i <= words.size(); i++){//но надо еще дописать именно подсчет ОДИНАКОВЫХ
            if((Collections.frequency(words, word) > 1) && ){//слова однаковы если их количетво символов и сами символы совпадают
                //тогда возможно words разбит на массив char-ов, и если words[chars] equals,  т.е. количество символов и идентичность букв совпадают в каждом элементе массива,то воспринимать этот эелемент как equalword
                // в ифе тогда будет words(chars).size()...дОВЕСТИ МЫСЛЬ..
                wordCounter += 1;
            }
        }
        return Integer.parseInt("Amount of equal words = " + wordCounter);
    }

        public void deleteSntncsWthLessWrds(File textFile, int n){//Удалить из текста все предложения с числом слов меньше заданного
        //допустим ранеее мы определили границу слова, ввели переменную word
// использовать метод remove
            for(int i = 0; i <= words.size(); i++){
                if(Collections.frequency(words, word) < n){
                    sentences.remove(sentence);//унаследовать коллекцию с sentences

                }
            }

        }
    }

