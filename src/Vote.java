public class Vote {
    private Person person;
    private String date;
    public Vote(Person person, String date){
        this.person = person;
        this.date = date;
    }
    public Person getPerson() {
        return person;
    }

    public String getDate() {
        return date;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Vote))
            return false;
        Vote vote = (Vote) o;
        if(!getPerson().equals(vote.getPerson()))
            return false;
        return getDate().equals(vote.getDate());
    }
    public int hashCode(){
        int result = getPerson().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }
}
