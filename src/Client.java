import java.util.LinkedList;

public class Client {
    String FIO;
    LinkedList<Bike> purchased = new LinkedList<>();
    LinkedList<Bike> fixed = new LinkedList<>();
    private int passport;

    Client(String name, int pass) throws MyException {
        FIO = name;
        passport = pass;
        if (this.purchased.size() != 0){
        for (int i = 0; i<Storage.getAll_byers().size(); i++){
            if (Storage.getAll_byers().get(i).equals(this)){
                throw new MyException ("Человек с таким паспортом уже существует");
            }
        }
        Storage.setAll_byers(this);}
    }

    public int  getPassport() {
        return this.passport;
    }

    public void setPassport(int pass) {
        this.passport = pass;
    }

    public boolean equals(Client cl){
        if (this.getPassport() == cl.getPassport()){
            return true;
        } else return false;
    }

    public String toString (){
        return ("ФИО: " + this.FIO + " ; данные паспорта: " + this.passport);
    }

}
