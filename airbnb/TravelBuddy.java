/**
I have a wish list of cities that I want to visit to, my friends also have city wish lists that they want to visit to. If one of my friends share more than 50% (over his city count in his wish list), he is my buddy.

Given a list of city wish list, output buddy list sorting by similarity.
 */
class Solution {
    private List<Buddy> res;

    public Solution(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
        res = new ArrayList<>();

        for (String name : friendsWishList.keySet()) {
            Set<String> wishList = friendsWishList.get(name);
            Set<String> intersection = new HashSet<>(wishList);
            intersection.retainAll(wishList);
            int similarity = intersection.size();
            if (similarity > wishList.size() / 2) {
                res.add(new Buddy(name, similarity, wishList));
            }
        }
    }

    public List<Buddy> getSortedBuddies() {
        Collections.sort(res);
        return res;
    }

    class Buddy implements Comparable<Buddy>{
        String name;
        int similarity;
        Set<String> wishList;

        public Buddy (String name, int similarity, Set<String> wishList) {
            this.name = name;
            this.similarity = similarity;
            this.wishList = wishList;
        }

        @override
        public int compareTo(Buddy buddy) {
            return this.similarity - buddy.similarity;
        }
    }
}