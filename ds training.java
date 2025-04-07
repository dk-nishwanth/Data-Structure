import java.util.*;

public class Main {

    // 1. Most Frequent Element in a List
    public static int mostFrequent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0, result = nums[0];
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > maxCount) {
                maxCount = count;
                result = num;
            }
        }
        return result;
    }

    // 2. Find the Missing Number in an Array
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int num : nums)
            total -= num;
        return total;
    }

    // 3. Find Duplicates in an Array
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                res.add(num);
            }
        }
        return res;
    }

    // 4. Move Zeroes
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }
        while (insertPos < nums.length)
            nums[insertPos++] = 0;
    }

    // 5. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 6. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // 7. Second Largest
    public static Integer secondLargest(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second == Integer.MIN_VALUE ? null : second;
    }

    // 8. Kth Largest Element in an Array
    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }

    // 9. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[k++] = nums[i];
        }
        return k;
    }

    // 10. Max Consecutive Ones
    public static int maxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        for (int num : nums) {
            count = (num == 1) ? count + 1 : 0;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // 11. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // 12. Majority Element (> n/3 times)
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > threshold)
                result.add(entry.getKey());
        }
        return result;
    }

    // 13. Longest Subarray With Sum K
    public static int longestSubarraySumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // 14. Maximum Subarray (Kadane's Algorithm)
    public static int maxSubarray(int[] nums) {
        int maxSum = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }

    // 15. Union of Two Sorted Arrays with Duplicates
    public static List<Integer> unionSortedArrays(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result.add(a[i++]);
            } else {
                result.add(b[j++]);
            }
        }
        while (i < a.length) result.add(a[i++]);
        while (j < b.length) result.add(b[j++]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("1. Most Frequent: " + mostFrequent(new int[]{1, 3, 2, 1, 4, 1}));
        System.out.println("2. Missing Number: " + missingNumber(new int[]{3, 0, 1}));
        System.out.println("3. Duplicates: " + findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        int[] zeroes = {0, 1, 0, 3, 12};
        moveZeroes(zeroes);
        System.out.println("4. Move Zeroes: " + Arrays.toString(zeroes));
        System.out.println("5. Subarray Sum K: " + subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println("6. Longest Substring: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("7. Second Largest: " + secondLargest(new int[]{10, 20, 4, 45, 99}));
        System.out.println("8. Kth Largest: " + kthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        int[] dupTest = {1, 1, 2, 2, 3, 4};
        int len = removeDuplicates(dupTest);
        System.out.println("9. Remove Duplicates Length: " + len + ", Array: " + Arrays.toString(Arrays.copyOf(dupTest, len)));
        System.out.println("10. Max Consecutive 1s: " + maxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println("11. Two Sum: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("12. Majority Elements: " + majorityElement(new int[]{3, 2, 3, 1, 2, 2}));
        System.out.println("13. Longest Subarray Sum K: " + longestSubarraySumK(new int[]{10, 5, 2, 7, 1, 9}, 15));
        System.out.println("14. Max Subarray: " + maxSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("15. Union of Sorted Arrays: " + unionSortedArrays(new int[]{1, 3, 5}, new int[]{2, 3, 4, 5, 6}));
    }
}