/**
   A class to represent an algebraic term.
*/
class Term
{
   private double coefficient;
   private int power;

   // constructor with parameters [1 point]
   ... ...

   // getters and setters [2 point]
   ... ...

   // Multiplies two coefficient together and returns the result [2 point]
   public Term multiply(Term t)
   {
      ... ...
   }

   // Adds the term to this term if the powers are the same [2 point]
   public void addIfSamePower(Term t)
   {
      ... ...
   }

   // Returns a string representation of the term [3 point]
   // with a ^ representing the exponent
   public String toString()
   {
     ... ...
   }
}
