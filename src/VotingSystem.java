import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    public VotingSystem(){
        votingList = new ArrayList<>();
    }
    public void createVoting(String question,int type,ArrayList<String> strings){
        Voting voting = new Voting(type, question);
        for(String str : strings) {
            voting.listOfVotesToChoices.put(str,new HashSet<Vote>());
        }
        votingList.add(voting);

    }
    public void clearVoting(int index){
        votingList.remove(index);

    }
    public void printVotingQuestions(){
        for(Voting vote : votingList)
            System.out.println(vote.getQuestion());
    }
    public void printVoting(int index){
        System.out.println(votingList.get(index).getQuestion());
        for(String str : votingList.get(index).listOfVotesToChoices.keySet())
            System.out.println(str);

    }
    public void vote(int index,Person person,ArrayList<String> str2){
        if(!(votingList.get(index).voters.contains(person))){
            for(int i=0;i<str2.size();i++){
                if(votingList.get(index).listOfVotesToChoices.containsKey(str2.get(i))) {
                    JalaliCalendar calendar = new JalaliCalendar(new GregorianCalendar());
                    Vote vote = new Vote(person,calendar.toString());
                    votingList.get(index).listOfVotesToChoices.get(str2.get(i)).add(vote);
                    if(votingList.get(index).getType()==0)
                        break;

                }
            }
            votingList.get(index).voters.add(person);
            System.out.println("vote submitted!");
        }

    }
    public void printResults(int index) {
        System.out.println("result:");
            for(String str : votingList.get(index).listOfVotesToChoices.keySet()) {
                    System.out.println(str + ":" + votingList.get(index).listOfVotesToChoices.get(str).size());
                for (Vote vt : votingList.get(index).listOfVotesToChoices.get(str)) {
                    System.out.println(vt.getPerson().toString());
                    System.out.println(vt.getDate());
                }

            }


    }
}
