package collections;


interface IPrintable {};
class A implements IPrintable { public void print(){System.out.println("a method");}  }
class B implements IPrintable { public void print(){System.out.println("b method");}  }

class clsDeneme{
	void invoke(IPrintable p) {
		if( p instanceof A) {
			A lcA = (A)p; //downcasting
			lcA.print();
		}
		if( p instanceof B) {
			B lcB = (B)p; //downcasting
			lcB.print();
		}
	}
}
public class denemeInheritance {

	public static void main(String[] args) {
		
		IPrintable p = new B();
		clsDeneme denemeCls = new clsDeneme();
		denemeCls.invoke(p);
		
		//Dog d = new Dog();
		//System.out.println( d instanceof Animal );
		
		//Dog d = new Animal(); //compilation error
		//Dog d = (Animal)new Animal(); //ClassCastException
		//Animal a = null;
		//Dog d = (Dog)a;
	}


}


