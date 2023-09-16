package com.gsonkeno.english.learn;

import com.gsonkeno.english.learn.model.WordDescription;
import com.gsonkeno.english.learn.repository.WordRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/word")
public class WordController {

    @RequestMapping(value = "/list/{index}")
    public List<String> list(@PathVariable("index") Integer index){
        String wordListIndex = "Word List " + index;
        List<WordDescription> wordList = WordRepository.getWordList();
        List<String> words = wordList.stream().filter(w -> w.getListIndex().equals(wordListIndex)).map(WordDescription::getWord).collect(Collectors.toList());
        return words;
    }

    @RequestMapping(value = "/length/{len}")
    public List<String> length(@PathVariable("len") Integer len){
        List<WordDescription> wordList = WordRepository.getWordList();
        List<String> words = wordList.stream().filter(w -> w.getWord().length() == len).map(WordDescription::getWord).collect(Collectors.toList());
        return words;
    }

    /**
     * 随机取100单词
     * @param totalList
     * @return
     */
    @RequestMapping(value = "/random/{totalList}")
    public List<String> random(@PathVariable("totalList") Integer totalList){
        List<WordDescription> wordList = WordRepository.getWordList();
        wordList = wordList.stream().filter(w -> w.getListNo() <= totalList).collect(Collectors.toList());
        int size = wordList.size();
        List<String> words = new ArrayList<>();
        Random random = new Random();
        int bound = size;
        for (int i = 0; i < 100; i++) {
            int idx = random.nextInt(bound);
            words.add(wordList.get(idx).getWord());
            wordList.set(idx, wordList.get(bound - 1));
            bound--;
        }
        return words;
    }


}
