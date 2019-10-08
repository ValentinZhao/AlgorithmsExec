public class Solution1108 {
    public String defangIPaddr(String address) {
        int size = address.length();
        for(int i = 0; i < size; i++) {
            if(address.charAt(i) == '.') {
                address = address.substring(0,i) + "[.]" + address.substring(++i,size);
                size += 2;
            }
        }
        return address;
    }
}
