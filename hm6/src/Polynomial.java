import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial
{
   // attributes [1 point]
   private LinkedList<Term> terms;
 
   // Constructs an empty polynomial [1 point]
   public Polynomial() {
      terms = new LinkedList<>();
   }

   // Constructs a new polynomial with the given term [1 point]
   public Polynomial(Term t) {
      this();
      terms.add(t);
   }

   // Adds the polynomial such that the terms are in sorted order [10 point]
   public void add(Polynomial p) {
      for (Term term : p.terms) {
         boolean added = false;
         ListIterator<Term> iterator = terms.listIterator();

         while (iterator.hasNext()) {
            Term current = iterator.next();

            if (term.getPower() > current.getPower()) {
               iterator.previous();
               iterator.add(term);
               added = true;
               break;
            } else if (term.getPower() == current.getPower()) {
               current.addIfSamePower(term);
               added = true;
               break;
            }
         }

         if (!added) {
            terms.add(term);
         }
      }
   }

   // Multiplies the given polynomial with this one and returns the result [3 point]
   public Polynomial multiply(Polynomial p){
      Polynomial result = new Polynomial();

      for (Term t1 : this.terms) {
         for (Term t2 : p.terms) {
            result.add(new Polynomial(t1.multiply(t2)));
         }
      }

      return result;
   }

   // Prints the polynomial "nicely" so that it reads from highest term to lowest
   // and doesn't have a leading "+" if the first term is positive. [4 point]
   public void print(){
      StringBuilder sb = new StringBuilder();

      for (Term t : terms) {
         if (!sb.isEmpty() && t.getCoefficient() >= 0) {
            sb.append(" + ");
         } else if (!sb.isEmpty() && t.getCoefficient() < 0) {
            sb.append(" ");
         }
         sb.append(t.toString());
      }

      System.out.print(sb);
   }

   // Tests your class
   public static void main(String[] args) {
      Polynomial p = new Polynomial(new Term(-10, 0));
      p.print();
      System.out.println("\nExpected: - 10.0");
      p.add(new Polynomial(new Term(-1, 1)));
      p.print();
      System.out.println("\nExpected: - 1.0x - 10.0");
      p.add(new Polynomial(new Term(9, 7)));
      p.print();
      System.out.println("\nExpected: 9.0x^7 - 1.0x - 10.0");
      p.add(new Polynomial(new Term(5, 10)));
      p.print();
      System.out.println("\nExpected: 5.0x^10 + 9.0x^7 - 1.0x - 10.0");

      Polynomial q = p.multiply(p);
      q.print();
      System.out.println("\nExpected: 25.0x^20 + 90.0x^17 + 81.0x^14 - 10.0x^11 - 100.0x^10 - 18.0x^8 - 180.0x^7 + 1.0x^2 + 20.0x + 100.0");
   }
}
