import ir.huri.jcal.JalaliCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    ArrayList<Person> voters;
    HashMap<String, HashSet<Vote>> listOfVotesToChoices;
    public Voting(int type, String question){
        this.type = type;
        this.question = question;
        voters = new ArrayList<>();
        listOfVotesToChoices = new HashMap<>();
    }

    public int getType() {
        return type;
    }

    public String getQuestion(){
        return question;
    }
    public void createChoice(String str1){
        listOfVotesToChoices.put(str1,new HashSet<Vote>());
    }
    public void vote(Person person, ArrayList<String> str){
        if(!(voters.contains(person))) {
            for(int i=0;i<str.size();i++) {
                if(listOfVotesToChoices.containsKey(str.get(i))) {
                    JalaliCalendar calendar = new JalaliCalendar(new GregorianCalendar());
                    listOfVotesToChoices.get(str.get(i)).add(new Vote(person, calendar.toString()));
                    if(type==0)
                        break;
                }
            }
            voters.add(person);
            System.out.println("vote've been submitted");
        }
    }
    public void printVotes(){
        System.out.println("the voting's result:");
        for(String i : listOfVotesToChoices.keySet())
        System.out.println(i + ")" + listOfVotesToChoices.get(i).size());

    }
    public ArrayList<String> getChoices(){
        ArrayList<String> choices = new ArrayList<>();
        for(String i : listOfVotesToChoices.keySet()) {
            choices.add(i);
        }
        return choices;
    }
    public void getVoters(){
        System.out.println("voters:");
        for(Person per : voters)
            System.out.println(per.toString());
    }

}
