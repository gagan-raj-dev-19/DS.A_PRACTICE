package Arrays.Medium;

public class FindFirstandLastPositionofElementinSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence
        result[0] = findFirst(nums, target);

        // If target is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }

        // Find the last occurrence
        result[1] = findLast(nums, target);

        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1; // Move to the left half
            } else {
                left = mid + 1; // Move to the right half
            }

            if (nums[mid] == target) {
                index = mid; // Update index if target is found
            }
        }

        return index;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }

            if (nums[mid] == target) {
                index = mid; // Update index if target is found
            }
        }

        return index;
    }
}


/*
public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};

    // Find the first occurrence
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            result[0] = i;
            break;
        }
    }

    // If target is not found, return [-1, -1]
    if (result[0] == -1) {
        return result;
    }

    // Find the last occurrence
    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] == target) {
            result[1] = i;
            break;
        }
    }

    return result;
}
---

 */