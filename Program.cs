namespace PrimeTesting_Console
{
	class Program
	{
		
	
		static void Main(String[] args)
		{
			
			int number;
			bool run = true;
			while(run){
				
				char choice;
				Console.WriteLine( "Would you like to continue? (y or n)");
				choice = Console.read();
				if(choice == 'y'){
						
					
					Console.Write("Enter a number to test: ");
					number = Convert.ToInt32(Console.readline());
					
					if(IsPrimeFermat(number, 100))
						Console.WriteLine( "Probably prime" )
					else
						Console.WriteLine( "Not prime" );
					
					Console.readline();
				}else if(choice == n){
					run = false;
					break;
				}else{
					Console.WriteLine("Enter a valid selection");
				}
			} 
		}


		private bool IsPrimeFermat(int number, int numTrials)
			{
				Random Rand = new Random();
				
				for (int trial = 0; trial < numTrials; trial++)
				{
					// Pick a random test number.
					int test = Rand.Next(2, number); // random integer between 2 and the number we investigate
					do
					{
						test = Rand.Next(2, number);
					} while (Gcd(test, number) != 1);
	
					// Make sure it is relatively prime with number.
	
					// Calculate: test ^ (number-1) mod number.
					int result = (int)Exponentiate(test, number - 1, number);
	
					// If this is not -1, then the number is not prime.
					if (result != 1) return false;
				}
	
				// If we made it this far, the number is probably prime.
				return true;
			}
			
		
		
		
		
		private long Exponentiate(long value, long exponent, long modulus)
			{
				// Make lists of powers and the value to that power.
				List<long> powers = new List<long>();
				List<long> valueToPowers = new List<long>();
	
				// Makes sure the value isn't greater than the modulus.
				value = value % modulus;
	
				// Start with the power 1 and value^1.
				long lastPower = 1;
				long lastValue = value;
				powers.Add(lastPower);
				valueToPowers.Add(lastValue);
	
				// Calculate other powers until we get to one bigger than exponent.
				while (lastPower < exponent)
				{
					lastPower *= 2;
					lastValue = (lastValue * lastValue) % modulus;
					powers.Add(lastPower);
					valueToPowers.Add(lastValue);
				}
	
				// Combine values to make the required power.
				long result = 1;
	
				// Get the index of the largest power that is smaller than exponent.
				for (int powerIndex = powers.Count - 1; powerIndex >= 0; powerIndex--)
				{
					// See if this power fits within exponent.
					if (powers[powerIndex] <= exponent)
					{
						// It fits. Use this power.
						exponent -= powers[powerIndex];
						result = (result * valueToPowers[powerIndex]) % modulus;
					}
				}
	
				// Return the result.
				return result;
			}
			
	}	
}
