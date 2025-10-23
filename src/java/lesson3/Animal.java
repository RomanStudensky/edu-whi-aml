package lesson3;
public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Жтвотное говорит: ");
    }

    static class Dog extends Animal {
        public Dog(String name, int age){
            super(name, age);
        }

        @Override
        public void makeSound(){
            System.out.println(name + " - Гав-гав!");
        }

        public void bark(){
            System.out.println(name + " - Гав-гав!");
        }
    }

    static class Cat extends Animal {
        public Cat(String name, int age){
            super(name, age);
        }

        @Override
        public void makeSound(){
            System.out.println(name + "- Мяу!");
        }

        public void meow(){
            System.out.println(name + "- Мяу!");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog("Juna", 2);
        Cat c = new Cat("Jull", 5);

        d.makeSound();
        c.makeSound();
    }

}