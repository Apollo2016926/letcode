package com.eden.questionbank.algorithms.simple;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gexx
 * @Description 简单 page 4  size 100
 * @Date 2021/2/8
 **/
public class SimpleFourthPage {

    /**
     * @Description 1313. 解压缩编码列表
     * @Author gexx
     * @Date 2021/2/8
     **/
    public static int[] decompressrlelist(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int i1 = 0; i1 < nums[i]; i1++) {
                list.add(nums[i + 1]);
            }
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * @Description 1317. 将整数转换为两个无零整数的和
     * @author gexx
     * @Date 2021/2/8
     **/
    public int[] getNoZeroIntegers(int n) {
        int[] rs = new int[2];
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return rs;
    }


    /**
     * @Description 1323. 6 和 9 组成的最大数字
     * @author gexx
     * @Date 2021/2/8
     **/
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        String s1 = s.replaceFirst("6", "9");
        Integer integer = Integer.valueOf(s1);
        return integer;
    }

    /**
     * @Description: 1374. 生成每种字符都是奇数个的字符串
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public String generateTheString(int n) {

        StringBuffer ret = new StringBuffer();
        if (n % 2 == 0) {
            ret.append("a");
            for (int i = 0; i < n - 1; i++) {
                ret.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                ret.append("a");
            }
        }

        return ret.toString();
    }

    /**
     * @Description: 1380. 矩阵中的幸运数
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] rMin = new int[r];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                rMin[i] = Math.min(rMin[i], matrix[i][j]);
                cMax[j] = Math.max(cMax[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }


    /**
     * @Description 1331. 数组序号转换
     * @author gexx
     * @Date 2021/2/9
     **/
    public int[] arrayRankTransform(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min] = 1;
        }

        int[] preSum = new int[count.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + count[i - 1];
        }

        int[] ans = new int[arr.length];
        int index = 0;
        for (int num : arr) {
            ans[index++] = preSum[num - min] + 1;
        }

        return ans;


    }

    /**
     * @Description 1332. 删除回文子序列
     * @author gexx
     * @Date 2021/2/9
     **/
    public int removePalindromeSub(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }
        return 2;
    }


    /**
     * @Description 1337. 矩阵中战斗力最弱的 K 行
     * @Author gexx
     * @Date 2021/2/9
     **/
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] tmp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            tmp[i][0] = i;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    tmp[i][1] += 1;
                }
            }
        }
        Arrays.sort(tmp, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tmp[i][0];
        }
        return res;

    }

    /**
     * @Description 1342. 将数字变成 0 的操作次数
     * @Author gexx
     * @Date 2021/2/10
     **/
    static int count = 0;

    public static int numberOfSteps(int num) {

        toZero(num);
        return count;
    }

    private static void toZero(int num) {
        if (num == 0) {
            return;
        }
        count++;
        if (num % 2 == 0) {
            toZero(num / 2);
        } else {

            toZero(num - 1);
        }
    }


    /**
     * @Description 1346. 检查整数及其两倍数是否存在
     * @Author gexx
     * @Date 2021/2/10
     **/
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;

    }


    /**
     * @Description 1351. 统计有序矩阵中的负数
     * @Author gexx
     * @Date 2021/2/10
     **/
    public int countNegatives(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (grid[i][i1] >= 0) {
                    num++;
                } else {
                    continue;
                }
            }
        }
        return num;
    }

    /**
     * @Description 1356. 根据数字二进制下 1 的数目排序
     * @author gexx
     * @Date 2021/2/11
     **/
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;

    }

    /**
     * @Description
     * @author gexx
     * @Date 2021/2/11
     **/
    public int daysBetweenDates(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);

        LocalDate endDate = LocalDate.parse(date2);


        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.abs((int) daysDiff);
    }

    /**
     * @Description 1365. 有多少小于当前数字的数字
     * @author gexx
     * @Date 2021/2/11
     **/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            ret[i] = cnt;
        }
        return ret;
    }


    /**
     * @Description: 1385. 两个数组间的距离值
     * @Author: gexx
     * @Date: 2021/2/20
     **/
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean allBigger = true;
            for (int i1 : arr2) {
                if (Math.abs(i - i1) <= d) {
                    allBigger = false;
                    break;
                }
            }
            if (allBigger) {
                count++;
            }
        }
        return count;

    }

    /**
     * @Description: 1389. 按既定顺序创建目标数组
     * @Author: gexx
     * @Date: 2021/2/20
     **/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * @Description: 1394. 找出数组中的幸运数
     * @Author: gexx
     * @Date: 2021/2/20
     **/
    public static int findLucky(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                if (count == arr[i + 1]) {
                    return count;
                }
                count = 1;
            }
        }
        if (count == arr[0]) {
            return count;
        }

        return -1;
    }

    /**
     * @Description: 1399. 统计最大组的数目
     * @Author: gexx
     * @Date: 2021/2/21
     **/
    public int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, i0 = i;
            while (i0 != 0) {
                key += i0 % 10;
                i0 /= 10;
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
            if (kvpair.getValue() == maxValue) {
                ++count;
            }
        }
        return count;
    }

    /**
     * @Description: 1403. 非递增顺序的最小子序列
     * @Author: gexx
     * @Date: 2021/2/21
     **/
    public static List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        int reverseNums[] = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--) {
            sum += nums[i];
            reverseNums[j++] = nums[i];

        }
        List<Integer> result = new ArrayList<>();
        int subSum = 0;
        for (int reverseNum : reverseNums) {
            subSum += reverseNum;
            result.add(reverseNum);
            if (subSum > sum - subSum) {
                return result;
            }
        }

        return result;
    }

    /**
     * @Description: 1408. 数组中的字符串匹配
     * @Author: gexx
     * @Date: 2021/2/21
     **/
    public List<String> stringMatching(String[] words) {

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(".").append(word);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (sb.indexOf(word) != sb.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;

    }

    /**
     * @Description: 3. 逐步求和得到正数的最小值
     * @Author: gexx
     * @Date: 2021/2/22
     **/
    public static int minStartValue(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }
        return minSum >= 1 ? 1 : 1 - minSum;
    }

    /**
     * @Description: 1417. 重新格式化字符串
     * @Author: gexx
     * @Date: 2021/2/22
     **/
    public String reformat(String s) {
        StringBuilder lettersb = new StringBuilder();
        StringBuilder numsb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                lettersb.append(ch);
            } else {
                numsb.append(ch);
            }
        }
        int letterLength = lettersb.length();
        int numLength = numsb.length();
        if (Math.abs(letterLength - numLength) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if (letterLength >= numLength) {

            for (int i = 0; i < numLength; i++) {
                sb.append(lettersb.charAt(i));
                sb.append(numsb.charAt(i));
            }
            if (letterLength > numLength) {
                sb.append(lettersb.charAt(letterLength - 1));
            }
        } else {
            for (int i = 0; i < letterLength; i++) {
                sb.append(numsb.charAt(i));
                sb.append(lettersb.charAt(i));
            }
            sb.append(numsb.charAt(numLength - 1));
        }
        return sb.toString();

    }

    /**
     * @Description: 1422. 分割字符串的最大得分
     * @Author: gexx
     * @Date: 2021/2/22
     **/
    public int maxScore(String s) {
        int res = 0, cnt1 = 0, cnt0 = 0;        //cnt1统计右边1的个数，同理cnt0左边0的个数
        for (int i = 0; i < s.length(); i++) {
            cnt1 += s.charAt(i) - '0';            //先统计1的个数
        }                                       //由于左右区域的数至少为1，所以i不能等于len-1
        for (int i = 0; i < s.length() - 1; i++) {  //点i分为左右两个区域
            if (s.charAt(i) == '0') {
                cnt0++;      //遇到01就统计，动态更新左右区域01个数
            } else {
                cnt1--;
            }
            res = Math.max(res, cnt0 + cnt1);
        }
        return res;
    }

    /**
     * @Description: 1431. 拥有最多糖果的孩子
     * @Author: gexx
     * @Date: 2021/2/23
     **/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (max <= candies[i] + extraCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    /**
     * @Description: 1436. 旅行终点站
     * @Author: gexx
     * @Date: 2021/2/23
     **/
    public static String destCity(List<List<String>> paths) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (List<String> path : paths) {
            hashMap.put(path.get(0), path.get(1));
        }
        String key = paths.get(0).get(0);
        while (hashMap.containsKey(key)) {
            String value = hashMap.get(key);
            key = value;
        }
        return key;


    }

    /**
     * @Description: 1437. 是否所有 1 都至少相隔 k 个元素
     * @Author: gexx
     * @Date: 2021/2/23
     **/
    public static boolean kLengthApart(int[] nums, int k) {
        List<Integer> l = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                l.add(i);
            }
        }
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i + 1) - l.get(i) < k) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 1441. 用栈操作构建数组
     * @Author: gexx
     * @Date: 2021/2/24
     **/
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int idx = 0, num = 1, len = target.length;

        while (idx < len && num <= n) {
            ans.add("Push");

            if (target[idx] != num) {
                ans.add("Pop");
            } else {
                idx++;
            }

            num++;
        }

        return ans;
    }

    /**
     * @Description: 1446. 连续字符
     * @Author: gexx
     * @Date: 2021/2/24
     **/
    public int maxPower(String s) {
        int max = 1;
        int count = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                if (i == chars.length - 1) {
                    max = Math.max(max, count);
                }

            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return max;

    }

    /**
     * @Description: 1450. 在既定时间做作业的学生人数
     * @Author: gexx
     * @Date: 2021/2/24
     **/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime < endTime[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * @Description: 1455. 检查单词是否为句中其他单词的前缀
     * @Author: gexx
     * @Date: 2021/2/25
     **/
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].indexOf(searchWord) == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * @Description: 1460. 通过翻转子数组使两个数组相等
     * @Author: gexx
     * @Date: 2021/2/25
     **/
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 64. 数组中两元素的最大乘积
     * @Author: gexx
     * @Date: 2021/2/25
     **/
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    /**
     * @Description: 1470. 重新排列数组
     * @Author: gexx
     * @Date: 2021/2/26
     **/
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n];

        }
        return result;
    }

    /**
     * @Description: 1475. 商品折扣后的最终价格
     * @Author: gexx
     * @Date: 2021/2/26
     **/
    public static int[] finalPrices(int[] prices) {

        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }

    /**
     * @Description: 1480. 一维数组的动态和
     * @Author: gexx
     * @Date: 2021/2/26
     **/
    public int[] runningSum(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }


    /**
     * @Description: 1518. 换酒问题
     * @Author: gexx
     * @Date: 2021/3/1
     **/
    public static int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }

    /**
     * @Description: 1523. 在区间范围内统计奇数数目
     * @Author: gexx
     * @Date: 2021/3/1
     **/
    public int countOdds(int low, int high) {

        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }

    /**
     * @Description: 1528. 重新排列字符串
     * @Author: gexx
     * @Date: 2021/3/1
     **/
    public static String restoreString(String s, int[] indices) {
        int length = s.length();
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);

    }

    /**
     * @Description: 1534. 统计好三元组
     * @Author: gexx
     * @Date: 2021/3/2
     **/
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c
                    ) {
                        count++;
                    }

                }
            }
        }
        return count;
    }

    /**
     * @Description: 1539. 第 k 个缺失的正整数
     * @Author: gexx
     * @Date: 2021/3/2
     **/
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + n;
    }

    /**
     * @Description: 1544. 整理字符串
     * @Author: gexx
     * @Date: 2021/3/2
     **/
    public String makeGood(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();

    }

    /**
     * @Description: 1550. 存在连续三个奇数的数组
     * @Author: gexx
     * @Date: 2021/3/3
     **/
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 千位分隔数
     * @Author: gexx
     * @Date: 2021/3/3
     **/
    public String thousandSeparator(int n) {

        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int bite = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (bite == 3) {
                sb.append(".");
                bite = 0;
            }
            sb.append(s.charAt(i));
            bite++;

        }


        return sb.reverse().toString();

    }

    /**
     * @Description: 1560. 圆形赛道上经过次数最多的扇区
     * @Author: gexx
     * @Date: 2021/3/3
     **/
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ret = new ArrayList<Integer>();
        int length = rounds.length;
        int start = rounds[0], end = rounds[length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ret.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                ret.add(i);
            }
            for (int i = start; i <= n; i++) {
                ret.add(i);
            }
        }
        return ret;

    }

    /**
     * @Description: 1566. 重复至少 K 次且长度为 M 的模式
     * @Author: gexx
     * @Date: 2021/3/4
     **/
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int l = 0; l <= n - m * k; ++l) {
            int offset;
            for (offset = 0; offset < m * k; ++offset) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;

    }

    /**
     * @Description: 1572. 矩阵对角线元素的和
     * @Author: gexx
     * @Date: 2021/3/4
     **/
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < n; ++i) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        return sum - mat[mid][mid] * (n & 1);

    }

    /**
     * @Description: 1576. 替换所有的问号
     * @Author: gexx
     * @Date: 2021/3/4
     **/
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if ('?' == chars[i]) {
                char first = i == 0 ? ' ' : chars[i - 1];
                char last = i == chars.length - 1 ? ' ' : chars[i + 1];
                char replaceChar = 'a';
                while (replaceChar == first || replaceChar == last) {
                    replaceChar++;
                }
                chars[i] = replaceChar;

            }

        }

        return new String(chars);
    }

    /**
     * @Description: 1582. 二进制矩阵中的特殊位置
     * @Author: gexx
     * @Date: 2021/3/5
     **/
    public int numSpecial(int[][] mat) {
        int[] sumOfrows = new int[mat.length];
        int[] sumOfcols = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sumOfrows[i] += mat[i][j];
                sumOfcols[j] += mat[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (sumOfrows[i] == 1 && sumOfcols[j] == 1 && mat[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @Description: 1588. 所有奇数长度子数组的和
     * @Author: gexx
     * @Date: 2021/3/5
     **/
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, res = 0;
        for (int i = 0; i < len; i++) {
            int leftOdd = (i + 1) / 2, leftEven = i / 2 + 1;
            int rightOdd = (len - i) / 2, rightEven = (len - 1 - i) / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return res;

    }

    /**
     * @Description: 1592. 重新排列单词间的空格
     * @Author: gexx
     * @Date: 2021/3/5
     **/
    public String reorderSpaces(String text) {

        int bc = 0, wc = 0;
        for (int i = 0; i < text.length(); i++) {
            //计算空格数
            if (text.charAt(i) == ' ') {
                bc++;
            }
            //计算单词数
            if ((i == 0 || text.charAt(i - 1) == ' ') && text.charAt(i) != ' ') {
                wc++;
            }
        }
        int ec = wc == 1 ? bc : bc / (wc - 1); //计算单词间的空格数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (sb.length() == 0 && text.charAt(i) == ' ') {
                continue;
            }
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i));
            } else if (text.charAt(i - 1) != ' ' && text.charAt(i) == ' ') {
                for (int j = 0; j < ec; j++) {
                    sb.append(' ');
                }
            }

        }
        while (sb.length() < text.length()) {
            sb.append(' ');
        }
        if (sb.length() > text.length()) {
            sb.delete(text.length(), sb.length());
        }
        return sb.toString();


    }


    /**
     * @Description 1598. 文件夹操作日志搜集器
     * @author gexx
     * @Date 2021/3/6
     **/
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if ("./".equals(log)) {

            } else if ("../".equals(log) && level != 0) {
                level--;
            } else if (!"./".equals(log) && !"../".equals(log)) {
                level++;
            }
        }

        return level;
    }


    /**
     * @Description 1603. 设计停车系统
     * @Author gexx
     * @Date 2021/3/6
     **/
    class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1: {
                    big--;

                    return big >= 0;
                }
                case 2: {
                    medium--;
                    return medium >= 0;
                }
                case 3: {
                    small--;
                    return small >= 0;
                }
                default: {
                    return false;
                }

            }

        }
    }


    /**
     * @Description 1608. 特殊数组的特征值
     * @author gexx
     * @Date 2021/3/6
     **/
    public int specialArray(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i <= nums[j]) {
                    if (length - j == i) {
                        return i;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;

    }

    /**
     * @Description: 1614. 括号的最大嵌套深度
     * @Author: gexx
     * @Date: 2021/3/8
     **/
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (char ch : s.toCharArray()) {
            if ('(' == ch) {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (')' == ch) {
                depth--;
            }
        }
        return maxDepth;
    }

    /**
     * @Description: 1619. 删除某些元素后的数组均值
     * @Author: gexx
     * @Date: 2021/3/8
     **/
    public static double trimMean(int[] arr) {
        double sum = 0;
        Arrays.sort(arr);
        int length = arr.length;
        int percentNum = length / 20;
        for (int i = percentNum; i < length - percentNum; i++) {
            sum += arr[i];
        }
        double res = sum / (length - 2 * percentNum);
        return res;

    }

    /**
     * @Description: 1624. 两个相同字符之间的最长子字符串
     * @Author: gexx
     * @Date: 2021/3/8
     **/
    public static int maxLengthBetweenEqualCharacters(String s) {

        int ans = -1;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, s.lastIndexOf(i + 'a') - s.indexOf(i + 'a') - 1);
        }
        return ans;

    }

    /**
     * @Description: 1629. 按键持续时间最长的键
     * @Author: gexx
     * @Date: 2021/3/9
     **/
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] keysHold = new int[keysPressed.length()];
        keysHold[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            keysHold[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        int maxV = 0;
        char re = 'A';
        Map<Integer, Character> map = new HashMap();
        for (int i = 0; i < keysHold.length; i++) {
            if (keysHold[i] > maxV) {
                maxV = keysHold[i];
                re = keysPressed.charAt(i);

            } else if (keysHold[i] == maxV) {
                if (keysPressed.charAt(i) > re) {
                    re = keysPressed.charAt(i);
                }
            }

        }


        return re;
    }

    /**
     * @Description: 1636. 按照频率将数组升序排序
     * @Author: gexx
     * @Date: 2021/3/9
     **/
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums) {
            cnts[n + 100]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }

    /**
     * @Description: 1640. 能否连接形成数组
     * @Author: gexx
     * @Date: 2021/3/9
     **/
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] map = new int[101];// 因为 1 <= arr[i], pieces[i][j] <= 100
        Arrays.fill(map, -1);// 所有值初始化为 -1，方便后面判断
        for (int i = 0; i < pieces.length; i++) {
            // 每个piece的第一个值作为数组map的index，piece在pieces中的index作为数组map对应的值
            map[pieces[i][0]] = i;
        }
        // 注意：for()这里不要写 i++ 了，也可改用while循环
        for (int i = 0; i < arr.length; ) {
            int pieceIndex = map[arr[i]];
            if (pieceIndex != -1) {
                int[] piece = pieces[pieceIndex];
                i++;
                // 从1开始遍历，0位置肯定符合，不用比了
                for (int j = 1; j < piece.length; j++) {
                    if (arr[i] != piece[j]) {
                        return false;
                    } else {
                        i++;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 1646. 获取生成数组中的最大值
     * @Author: gexx
     * @Date: 2021/3/10
     **/
    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        if (n < 2) {
            return n;
        }
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * @Description: 1652. 拆炸弹
     * @Author: gexx
     * @Date: 2021/3/10
     **/
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[code.length];
        if (k > 0) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                result[i] = sum - code[i] + code[(i + k) % n];
                sum = result[i];
            }
        } else if (k < 0) {
            int sum = 0;
            for (int i = 0; i < -k; i++) {
                sum += code[i];
            }
            for (int i = -k + 1; i < n - k + 1; i++) {
                result[i % n] = sum - code[(i + k - 1) % n] + code[(i - 1) % n];
                sum = result[i % n];
            }
        }
        return result;
    }

    /**
     * @Description: 1656. 设计有序流
     * @Author: gexx
     * @Date: 2021/3/10
     **/
    class OrderedStream {
        String[] stream;
        int ptr = 0;

        public OrderedStream(int n) {
            // 根据长度创建String数组保存值
            stream = new String[n];
        }

        public List<String> insert(int id, String value) {
            // id从1起始，所以减1
            stream[id - 1] = value;
            // 要返回的数组
            List<String> list = new ArrayList<>();
            // 从ptr开始，直到数组的末尾
            for (int i = ptr; i < stream.length; i++) {
                // 如果遇到流中的空值，跳出循环直接返回list
                if (stream[i] == null) {
                    break;
                } else { // 如果该处不为空值，那么ptr就可以到这个地方，返回的list中也应包括这个值
                    ptr++;
                    list.add(stream[i]);
                }
            }
            return list;
        }
    }

    /**
     * @Description: 1662. 检查两个字符串数组是否相等
     * @Author: gexx
     * @Date: 2021/3/11
     **/
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }


        return sb1.toString().equals(sb2.toString());
    }

    /**
     * @Description: 1668. 最大重复子字符串
     * @Author: gexx
     * @Date: 2021/3/11
     **/
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        String repetWord = word;
        while (sequence.indexOf(repetWord) != -1) {
            repetWord = repetWord + word;
            max++;

        }
        return max;

    }

    /**
     * @Description: 1672. 最富有客户的资产总量
     * @Author: gexx
     * @Date: 2021/3/11
     **/
    public int maximumWealth(int[][] accounts) {
        int maxRich = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }

            maxRich = Math.max(sum, maxRich);

        }
        return maxRich;

    }

    /**
     * @Description: 1678. 设计 Goal 解析器
     * @Author: gexx
     * @Date: 2021/3/12
     **/
    public static String interpret(String command) {
        command = command.replace("(al)", "al");
        command = command.replace("()", "o");
        return command;
    }

    /**
     * @Description: 1684. 统计一致字符串的数目
     * @Author: gexx
     * @Date: 2021/3/12
     **/
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            boolean consistent = true;
            for (char ch : word.toCharArray()) {
                if (allowed.indexOf(ch) == -1) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                count++;
            }
        }
        return count;
    }

    /**
     * @Description: 1688. 比赛中的配对次数
     * @Author: gexx
     * @Date: 2021/3/12
     **/
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            count += n / 2;
            n = n / 2 + n % 2;

        }
        return count;
    }

    /**
     * @Description: 1716. 计算力扣银行的钱
     * @Author: gexx
     * @Date: 2021/3/15
     **/
    public int totalMoney(int n) {
        int day = n % 7, week = n / 7;
        return ((day + 1) * day) / 2 + day * week + (((week + 7) * week) / 2) * 7;
    }

    /**
     * @Description: 1720. 解码异或后的数组
     * @Author: gexx
     * @Date: 2021/3/15
     **/
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];

        }

        return arr;

    }

    /**
     * @Description: 1725. 可以形成最大正方形的矩形数目
     * @Author: gexx
     * @Date: 2021/3/15
     **/
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, ans = 0;
        for (int[] rect : rectangles) {
            int len = Math.min(rect[0], rect[1]);
            if (len > maxLen) {
                maxLen = len;
                ans = 1;
            } else if (len == maxLen) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @Description: 1732. 找到最高海拔
     * @Author: gexx
     * @Date: 2021/3/16
     **/
    public static int largestAltitude(int[] gain) {
        int res[] = new int[gain.length + 1];

        int x = -Integer.MAX_VALUE;
        for (int i = 0; i < res.length - 1; i++) {
            res[i + 1] = res[i] + gain[i];
            x = Math.max(x, res[i + 1]);
        }

        return Math.max(x, res[0]);
    }

    /**
     * @Description: 1752. 检查数组是否经排序和轮转得到
     * @Author: gexx
     * @Date: 2021/3/16
     **/
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
        }
        return count <= 1;
    }

    /**
     * @Description: 1758. 生成交替二进制字符串的最少操作数
     * @Author: gexx
     * @Date: 2021/3/16
     **/
    public int minOperations(String s) {
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == i % 2) {
                count1++;
            } else {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }

    /**
     * @Description: LCP 01. 猜数字
     * @Author: gexx
     * @Date: 2021/3/17
     **/
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * @Description: LCP 02. 分式化简
     * @Author: gexx
     * @Date: 2021/3/17
     **/
    public int[] fraction(int[] cont) {
        int m = 0;
        int n = 1;
        for (int i = cont.length - 1; i >= 0; i--) {
            m = n * cont[i] + m;
            int t = n;
            n = m;
            m = t;
        }
        return new int[]{n, m};

    }

    /**
     * @Description: LCP 06. 拿硬币
     * @Author: gexx
     * @Date: 2021/3/17
     **/
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count = count + coin / 2 + coin % 2;

        }
        return count;
    }

    /**
     * @Description: LCP 07. 传递信息
     * @Author: gexx
     * @Date: 2021/3/17
     **/
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int[] arr : relation) {
                dp[i][arr[1]] += dp[i - 1][arr[0]];
            }
        }
        return dp[k][n - 1];
    }

    /**
     * @Description: LCP 17. 速算机器人
     * @Author: gexx
     * @Date: 2021/3/18
     **/
    public int calculate(String s) {
        int x = 1, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('A' == s.charAt(i)) {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    /**
     * @Description: LCP 18. 早餐组合
     * @Author: gexx
     * @Date: 2021/3/18
     **/
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int cnt = 0;
        int m = staple.length, n = drinks.length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                cnt = (cnt + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return cnt % 1000000007;

    }

    /**
     * @Description: LCP 22. 黑白方格画
     * @Author: gexx
     * @Date: 2021/3/18
     **/
    public int paintingPlan(int n, int k) {

        if (k == n * n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i * n + (n - i) * j == k) {
                    count += sumC(i, n) * sumC(j, n);
                }
            }
        }
        return count;
    }

    int sumC(int m, int n) {

        int i = recurrence(n) / (recurrence(m) * recurrence(n - m));
        return i;
    }

    int recurrence(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * recurrence(num - 1);
        }
    }
   static Pattern p = Pattern.compile("(name:)([a-zA-Z]*)(,age:)([0-9]*)");

    public static void main(String[] args) {
        largestAltitude(new int[]{44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81});
        interpret("G()(al)");
        maxLengthBetweenEqualCharacters("scayofdzca");
        trimMean(new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4});
        String[] s = "js  jj   ss".split(" ");
        System.out.println(Arrays.toString(s));

        findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        restoreString("aiohn", new int[]{3, 1, 4, 2, 0});
        finalPrices(new int[]{8, 4, 6, 2, 3});
        kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2);
        minStartValue(new int[]{
                -3, 2, -3, 4, 2});
        findLucky(new int[]{1, 2, 2, 3, 3, 3});
        findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3);
        decompressrlelist(new int[]{1, 2, 3, 4});


        Matcher m = p.matcher("name:vunv,age:20");
        while (m.find()) {
            System.out.println(m.group(2));
            System.out.println(m.group(4));
        }

    }
}

