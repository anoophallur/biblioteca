package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/17/12
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String Name;
    private char Gender;
    private int Age;



    private Library MemberofLibrary;    //In this case Assumed that A person will not be member of more than 1 Library
    private long LibraryNumber;
    private Book[] booksTaken = new Book[MAX_NO_OF_BOOKS_A_USER_CAN_HAVE];
    int noOfBooksTaken;
    private static final int MAX_NO_OF_BOOKS_A_USER_CAN_HAVE = 3 ;

    public User(String Name, char Gender, int Age, long LibraryNumber) {
        this.setName(Name);
        this.setGender(Gender);
        this.setAge(Age);
        this.setMemberofLibrary(null);
        this.setLibraryNumber(LibraryNumber);
        this.setBooksTaken();
        this.setNoOfBooksTaken(0);
        return;
    }

    private void setNoOfBooksTaken(int noOfBooksTaken) {
        this.noOfBooksTaken = noOfBooksTaken;
    }

    private void setBooksTaken() {

        for (int i = 0 ; i < booksTaken.length ; i++){
            booksTaken[i] = null;
        }
    }

    public User() {
        this.setName(" ");
        this.setGender(' ');
        this.setAge(0);
        this.setMemberofLibrary(null);
        this.setLibraryNumber(0);
        this.setBooksTaken();
        this.setNoOfBooksTaken(0);

        return;
    }

    public User(long libraryNumber) {
        this.setName(" ");
        this.setGender(' ');
        this.setAge(0);
        this.setMemberofLibrary(null);
        this.setLibraryNumber(libraryNumber);
        this.setBooksTaken();
        this.setNoOfBooksTaken(0);

        return;
    }

    private void setMemberofLibrary(Library libraryobject) {
        this.MemberofLibrary = libraryobject;
        return;
    }

    private void setLibraryNumber(long LibraryNumber) {
        this.LibraryNumber = LibraryNumber;
        return;
    }

    private void setAge(int Age) {
        this.Age = Age;
        return;
    }

    private void setGender(char Gender) {
        this.Gender = Gender;
        return;
    }

    private void setName(String Name) {
        this.Name = Name;
        return;
    }


    public boolean addTothisLibrary(Library libraryOjbect) {
        this.setMemberofLibrary(libraryOjbect);
        return libraryOjbect.addNewMember(this);
    }

    public boolean amIHavingThisLIBRARYIDNumber(long libraryID) {
        if(this.getLibraryIDNumber() == libraryID )
            return  true;
        else
            return false;
    }

    private long getLibraryIDNumber() {
        return this.LibraryNumber;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean viewMyProfileInTheLibrary(Library libraryOjbect) {
        return libraryOjbect.displayUserProfile(this.LibraryNumber);
    }

    public boolean displayDetails() {
        System.out.println("Name-->" + this.Name + "\tLibrary ID-->" + this.LibraryNumber +
                           "\tGender-->" + this.Gender + "\tAge-->" + this.Age);
        return true;
    }

    public boolean viewAllBooksInMyLibrary() {
        return MemberofLibrary.displayAllBooks();
    }

    public boolean reserveBookInLibrary(String UserRequestedISBN) {
        boolean status = MemberofLibrary.reserveBook(UserRequestedISBN);
        if(status == true){

            Book bookobjectTakenByThisUser = new Book(UserRequestedISBN);
            this.setBooksTaken(bookobjectTakenByThisUser);
            this.noOfBooksTaken++;
        }
        return status;
    }

    private void setBooksTaken(Book bookobjectTakenByThisUser) {
        this.booksTaken[this.noOfBooksTaken] = bookobjectTakenByThisUser;
    }
    public Library getMemberofLibrary() {
        return MemberofLibrary;
    }

    public boolean displayMoviesList() {
        return getMemberofLibrary().viewMovieDataBase();
    }
}
