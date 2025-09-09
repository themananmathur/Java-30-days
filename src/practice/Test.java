package practice;

class Animal{
 public void Sound(){
     System.out.println("Sound");
 }
}

class Dog extends Animal{
    @Override
    public void Sound(){
        System.out.println("Dog barks");
    }
}

public class Test{
    public static void main(String[] args){
        Animal a = new Animal();
        Animal d = new Dog();

        a.Sound();
        d.Sound();
    }
}