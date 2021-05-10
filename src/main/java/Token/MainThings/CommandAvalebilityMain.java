package Token.MainThings;

public class CommandAvalebilityMain {
    boolean ann=true;
    boolean echo=true;
    boolean help=true;
    boolean inv=true;
    boolean joke=true;
    boolean ping=true;
    boolean user_pings=false;
    boolean sleep=false;
    boolean test=false;
    boolean pp=true;
    boolean dont=true;
    boolean spoki=false;
    boolean alphabet=true;
    boolean emergency=true;
    boolean calculator=true;
    boolean gifTest=false;
    boolean listUsr=true;
    boolean listAll=true;

    @Override
    public String toString() {
        return "```c++\nCommand Availability's\n"+
                "!ann - "+ann+"\n"+
                "!echo - "+echo+"\n"+
                "!help - "+help+"\n"+
                "!inv - "+inv+"\n"+
                "!joke - "+joke+"\n"+
                "!ping - "+ping+"\n"+
                "user pings - "+user_pings+"\n"+
                "!sleep - "+sleep+"\n"+
                "!pp - "+pp+"\n"+
                "!test - "+test+"\n"+
                "!dont - "+dont+"\n"+
                "!spoki - "+spoki+"\n"+
                "!iDumb - "+alphabet+"\n"+
                "!emer - "+emergency+"\n" +
                "!calc - "+calculator+"\n"+
                "!emojiTst - "+gifTest+"\n"+
                "!listUsr - "+listUsr+"\n"+
                "!listAll - "+listAll+"\n"+"```";
    }
}
