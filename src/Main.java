import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	VotingSystem votingSystem = new VotingSystem();
	Person voter = new Person("Shamim","Morvarid");
        ArrayList options = new ArrayList();
        ArrayList days = new ArrayList();
        options.add("yes");
        options.add("no");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        votingSystem.createVoting("Do you come?",0,options);
        votingSystem.createVoting("which day?",1,days);
        System.out.println("printVotingQuestions");
        votingSystem.printVotingQuestions();
        System.out.println("printVoting");
        votingSystem.printVoting(0);
        ArrayList votes = new ArrayList();
        votes.add("yes");
        ArrayList vote2 = new ArrayList();
        vote2.add("Thursday");
        vote2.add("Friday");
        votingSystem.vote(0,new Person("voter","voter"),votes);
        votingSystem.vote(0,voter,votes);
        votingSystem.printVoting(1);
        votingSystem.vote(1,voter,vote2);
        System.out.println("printResult:");
        votingSystem.printResults(0);
        votingSystem.printResults(1);
    }
}
