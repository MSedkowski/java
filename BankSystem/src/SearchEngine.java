public class SearchEngine {
    
    public int[] compareByName(AccountList newList, String answer) {
        int[] results = {0};
        int j = -1;
        for (int i = 0; i < newList.getList().size(); i++) {
            AccountData newData = newList.getList().get(i);
            if (newData.owner.getName().compareToIgnoreCase(answer) == 0) {
                j++;
                results[j] = i;
            }
        }
        if (j == -1) {
            return null;
        }
        else {
            return results;
        }
    }
    
    public void showResults(AccountList newList, int[] results) {
        System.out.println("Dane konta spelniajace zadane kryteria wyszukiwania: ");
        for(int i = 0; i < results.length; i++) {
            newList.getList().get(results[i]);
        }
    }
}
