package sumseries;
public static void selectionSort(int[] nums)
{
int n = nums.length;
int min, index, temp;
for (int j = 0; j < n-1; j++)
{
min = nums[j];
index = j;
for(int k = j+1; k < n; k++)
if(nums[k] < min)
{
min = nums[k];
index = k;
}
if(index != j)
{
temp = nums[j];
nums[j] = nums[index];
nums[index] = temp;
}
}}