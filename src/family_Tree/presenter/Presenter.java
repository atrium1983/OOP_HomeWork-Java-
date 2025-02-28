package family_Tree.presenter;

import family_Tree.model.human.Gender;
import family_Tree.model.human.Human;
import family_Tree.model.service.Service;
import family_Tree.model.writer.Writable;
import family_Tree.view.View;

import java.time.LocalDate;

public class Presenter {

    private final View view;
    private final Service service;
    private final String positive = "Успешно!\n";

    public Presenter (View view){
        this.view = view;
        service = new Service();
    }

    public void save(){
        service.save();
        view.answer(positive);
    }

    public void load(){
        service.load();
        view.answer(positive);
    }

    public void sortByName(){
        service.sortByName();
        print();
    }
    public void sortByAge(){
        service.sortByAge();
        print();
    }
    public void sortById(){
        service.sortById();
        print();
    }
    public void addHuman(String name, LocalDate dateOfBirth, Gender gender){
        service.addHuman(name, dateOfBirth,gender);
        view.answer(positive);
        print();
    }
    public void generateTree(){
        service.generateTree();
        print();
    }
    public void print(){
        view.answer(service.printFullInfo());
    }

    public void printById(int id){
        view.answer(service.printHumanInfo(id));
    }

    public void addChild(int parentId, int childId){
        service.addChild(parentId, childId);
        view.answer(positive);
        printById(parentId);
    }

    public void addParent(int humanId, int parentId){
        service.addParent(humanId, parentId);
        view.answer(positive);
        printById(humanId);
    }

    public boolean findById(int id){
        return service.findById(id);
    }

    public void setDeathDate(int id, LocalDate date){
        service.setDeathDate(id, date);
        view.answer(positive);
        printById(id);
    }
    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
}
