package com.twu28.biblioteca;

import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/19/12
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceTest {
    @Test
    public void canWelcomeScreenBeSeen(){
        Interface console = new Interface();
        console.setTestRun();
        assertNotSame(-1,console.showMessage("Welcome to The Library"));

    }

    @Test
    public void canWeSeeTheMenu(){
        Interface console = new Interface();
        console.setTestRun();
        console.showMenu();

    }

    @Test
    public void menuOptionONESelectedToDisplayBooks(){

        Interface console = new Interface();
        console.setTestRun();
        User userObject = new User("Sample Name",'M',25,1232);  //User Details - Name,Gender,Age,Library Number
        Library libraryobject = new Library();

        Book[] bookobjects = new Book[2];
        bookobjects[0] = new Book("1234567890123","SampleTitle","SampleAuthor","SamplePublisher",1,2012,5);
        bookobjects[1] = new Book("3210987654321","SamplTitle1","SamplAuthor1","SamplPublisher1",1,2011,3);
        libraryobject.addBook(bookobjects);
        userObject.addTothisLibrary(libraryobject);           //Initialization Till Here

        assertTrue(console.displayBooksInLibrary(userObject));     //In Actual Case UserOjbect will be the person who
                                                                  //logged into his account

    }
    @Test
    public void menuOptionTWOSelectedToReserveBooks(){

        Interface console = new Interface();
        console.setTestRun();
        User userObject = new User("Sample Name",'M',25,1232);  //User Details - Name,Gender,Age,Library Number
        Library libraryobject = new Library();

        Book[] bookobjects = new Book[2];
        bookobjects[0] = new Book("1234567890123","SampleTitle","SampleAuthor","SamplePublisher",1,2012,5);
        bookobjects[1] = new Book("3210987654321","SamplTitle1","SamplAuthor1","SamplPublisher1",1,2011,3);
        libraryobject.addBook(bookobjects);
        userObject.addTothisLibrary(libraryobject);           //Initialization Till Here


        assertTrue(console.reserveBookInLibrary(userObject));     //In Actual Case UserOjbect will be the person who
                                                                    //logged into his account

    }

    @Test
    public void menuOptionTHREESelectedToViewMovies(){

        Interface console = new Interface();
        console.setTestRun();
        Movie [] movieobjects = new Movie[15];
        Random random = new Random();
        for (int i = 0 ; i < movieobjects.length ; i++){
            boolean whetherNA = random.nextBoolean();
            if(whetherNA == true){
                movieobjects[i] = new Movie("MovieName" + i,"DirectorName"+ i);
            }
            else{
                movieobjects[i] = new Movie("MovieName" + i,"DirectorName"+ i, (random.nextInt(10) + 1));
            }
        }


        User userObject = new User("Sample Name",'M',25,1232);  //User Details - Name,Gender,Age,Library Number
        Library libraryobject = new Library();
        libraryobject.addMovie(movieobjects);
        userObject.addTothisLibrary(libraryobject);


        assertTrue(console.viewMovieList(userObject));

    }

    @Test
    public void menuOptionFOURSelectedToViewProfile(){

        Interface console = new Interface();
        console.setTestRun();
        User userObject = new User("Sample Name",'M',25,1232);  //User Details - Name,Gender,Age,Library Number
        Library libraryobject = new Library();

        assertNotNull(userObject);
        userObject.addTothisLibrary(libraryobject);


        assertTrue(console.viewUsersProfile(userObject));     //In Actual Case UserOjbect will be the person who
                                                                    //logged into his account

    }

    @Test
    public void menuOptionFIVEToExit(){

        Interface console = new Interface();
        console.setTestRun();
        assertTrue(console.quitProgram());

    }

    @Test
    public void canSelectMenuOption(){

        Interface console = new Interface();
        console.setTestRun();
        Library libraryobject = new Library();

        User userObject = new User("Sample Name",'M',25,1232);  //User Details - Name,Gender,Age,Library Number
        userObject.addTothisLibrary(libraryobject);

        console.showMenu();
        assertTrue(console.waitForMenuSelection(userObject));

    }

    @Test
    public void canShowLoginOptions(){

        Interface console = new Interface();
        console.setTestRun();
        assertTrue(console.showLoginOptions());

    }

    @Test
    public void canWaitLoginOptions(){

        Interface console = new Interface();
        console.setTestRun();
        assertTrue(console.showLoginOptions());
        assertNotSame(0,console.waitForLoginType());

    }

}
