public class SearchEngine {
    
    public int[] compareByName(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getName().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareBySurname(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getSurname().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareByCity(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getCity().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareByStreet(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getStreet().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareByPostCode(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getPostCode().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareByPesel(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.owner.getPesel().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public int[] compareByAccountNumber(AccountList newList, String answer) {
        int[] results = new int[newList.getList().size()];
        int j = 0;
        for (int i = 0; i < newList.getList().size(); i++, j++) {
            AccountData newData = newList.getAccountData(i);
            if (newData.getAccountNumber().compareToIgnoreCase(answer) == 0) {
                results[j] = i;
            }
            else {
                results[j] = -1;
            }
        }
        return results;
    }
    
    public void showResults(AccountList newList, int[] results) {
        System.out.println("Dane konta spelniajace zadane kryteria wyszukiwania: ");
        for(int i = 0; i < results.length; i++) {
            if (results[i] != -1) newList.getAccountData(i).toString();
        }
    }
}
