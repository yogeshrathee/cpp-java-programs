#include<iostream>
#include<string>
using namespace std;

int main() 
{
  string str;
  getline(cin,str);

  int count[26] = {0};

  for (int i = 0; i < str.length(); i++)
    count[str[i] - 'a']++;

  for (int i = 0; i < 26; i++)
    if (count[i] > 1)
    
    
    cout << (char)(i + 'a') << " - " << count[i] << "\n";

  return 0;
}
