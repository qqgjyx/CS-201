/**
   A class to represent an algebraic term.
*/
class Term
{
   private double coefficient;
   private int power;

   // constructor with parameters [1 point]
   public Term(double coefficient, int power){
      this.coefficient = coefficient;
      this.power = power;
   }

   // getters and setters [2 point]
   public double getCoefficient() {
      return coefficient;
   }

   public int getPower() {
      return power;
   }

   public void setCoefficient(double coefficient) {
      this.coefficient = coefficient;
   }

   public void setPower(int power) {
      this.power = power;
   }

   // Multiplies two coefficient together and returns the result [2 point]
   public Term multiply(Term t)
   {
      return new Term(this.coefficient * t.coefficient, this.power + t.power);
   }

   // Adds the term to this term if the powers are the same [2 point]
   public void addIfSamePower(Term t)
   {
         if (this.power == t.power) {
         this.coefficient += t.coefficient;
      }
   }

   // Returns a string representation of the term [3 point]
   // with a ^ representing the exponent
   public String toString()
   {
      String coefficientToString = coefficient>=0? String.valueOf(coefficient) : "- " + Math.abs(coefficient);
      if (power == 0) return coefficientToString;
      if (power == 1) return coefficientToString + "x";
      return coefficientToString + "x^" + power;
   }
}
