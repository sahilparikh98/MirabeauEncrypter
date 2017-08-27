import java.util.HashMap;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
public class Encrypter {

	
	public static void main(String[] args) {
		
		HashMap<String, Integer> six = new HashMap<String, Integer>();
		HashMap<String, Integer> seven = new HashMap<String, Integer>();
		HashMap<String, Integer> eight = new HashMap<String, Integer>();
		HashMap<String, Integer> four = new HashMap<String, Integer>();
		HashMap<String, Integer> five = new HashMap<String, Integer>();
		ArrayList<HashMap<String, Integer>> sets = new ArrayList<HashMap<String, Integer>>();
		sets.add(four);
		sets.add(five);
		sets.add(six);
		sets.add(seven);
		sets.add(eight);
		six.put("i", 1);
		six.put("s", 2);
		six.put("u", 3);
		six.put("w", 4);
		six.put("b", 5);
		eight.put("k", 1);
		eight.put("t", 2);
		eight.put("d", 3);
		eight.put("q", 4);
		eight.put("r", 5);
		four.put("x", 1);
		four.put("l", 2);
		four.put("p", 3);
		four.put("a", 4);
		four.put("e", 5);
		seven.put("g", 1);
		seven.put("o", 2);
		seven.put("y", 3);
		seven.put("v", 4);
		seven.put("f", 5);
		five.put("z", 1);
		five.put("m", 2);
		five.put("c", 3);
		five.put("h", 4);
		five.put("n", 5);
		String[] options = {"Encrypt", "Decrypt"};
		int choice = JOptionPane.showOptionDialog(null, "Decrypt or Encrypt?", "Choose an option", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, "Encrypt");
		String input;
		if(choice == 0)
		{
			input = JOptionPane.showInputDialog("Please enter the sentence you wish to encrypt.");
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < input.length(); i++)
			{
				String toEncrypt = input.substring(i, i+1);
				int codeOne = 0;
				if(toEncrypt.equals("."))
				{
					builder.append(".\n");
					i++;
				}
				else if(!toEncrypt.equals(" "))
				{
					for(int j = 0; j < sets.size(); j++)
					{
						if(sets.get(j).containsKey(toEncrypt))
						{
							codeOne = j + 4;
							break;
						}
					}
					builder.append(codeOne);
					builder.append(sets.get(codeOne - 4).get(toEncrypt));
					builder.append('.');
				}
				else
				{
					builder.append(" ");
				}
				
			}
			JTextArea textArea = new JTextArea(builder.toString());
			textArea.setEditable(false);
			JOptionPane.showMessageDialog(null, textArea);
			System.exit(0);
		}
		else
		{
			StringBuilder builder = new StringBuilder();
			input = JOptionPane.showInputDialog("Please enter the sentence you wish to decrypt.");
			for(int i = 0; i < input.length(); i++)
			{
				if(input.substring(i, i+1).equals(" "))
				{
					builder.append(" ");
				}
				else if(input.substring(i, i+1).equals("."))
				{
					builder.append(".\n");
					i++;
				}
				else 
				{
					//String letter = input.substring(i, i+3);
					int set = Integer.parseInt(input.substring(i, i+1));
					int mapped = Integer.parseInt(input.substring(i+1, i+2));
					set -= 4;
					Set<String> keys = sets.get(set).keySet();
					for(String key : keys)
					{
						if(sets.get(set).get(key) == mapped)
						{
							builder.append(key);
						}
					}
					i += 2;
				}
			}
			JTextArea textArea = new JTextArea(builder.toString());
			textArea.setEditable(false);
			JOptionPane.showMessageDialog(null, textArea);
			System.exit(0);
		}
		
		
	}
}
