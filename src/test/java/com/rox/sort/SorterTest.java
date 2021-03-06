package com.rox.sort;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import java.util.Arrays;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assume.assumeThat;

/**
 * Common tests which apply to anything extending the {@link Sorter Sorter} interface.
 *
 * XXX Needs to take into account sort stability or Pitest will always see the
 *     untested stability of elements as a "changed conditional boundary → SURVIVED"
 *
 * @Author Ross W. Drew
 */
public abstract class SorterTest {

    public abstract Sorter getSorter();
    public abstract boolean isStable();

    @Test
    public void testSortEmptyComparableList(){
        Comparable[] list = new Comparable[] {};
        Comparable[] result = getSorter().sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortSingleComparableList(){
        Comparable[] list = new Comparable[] {42};
        Comparable[] result = getSorter().sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortDoubleSortedComparableList(){
        Comparable[] list = new Comparable[] {42, 43};
        Comparable[] result = getSorter().sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortDoubleUnsortedComparableList(){
        Comparable[] list = new Comparable[] {43, 42};
        Comparable[] result = getSorter().sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortUnsortedComparableListWithHighestAtEnd(){
        Comparable[] list = new Comparable[] {42, 1, 100};
        Comparable[] result = getSorter().sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortUnsortedComparableListWithLowestAtEnd(){
        Comparable[] list = new Comparable[] {42, 100, 1};
        Comparable[] result = getSorter().sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortReversedList(){
        Comparable[] list = new Comparable[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(0, result[i++]);
        assertEquals(1, result[i++]);
        assertEquals(2, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(4, result[i++]);
        assertEquals(5, result[i++]);
        assertEquals(6, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(8, result[i++]);
        assertEquals(9, result[i++]);
        assertEquals(10, result[i++]);
    }

    @Test
    public void testXXX(){
        Comparable[] list = new Comparable[] {0,10,1};
        Comparable[] result = getSorter().sort(list);

        /*DEBUG*/
        System.out.println(Arrays.toString(result));

        int i = 0;
        assertEquals(0, result[i++]);
        assertEquals(1, result[i++]);
        assertEquals(10, result[i++]);

    }

    @Test
    public void testSortRandomList(){
        Comparable[] list = new Comparable[] {7, 4, 8, 10, 6};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(4, result[i++]);
        assertEquals(6, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(8, result[i++]);
        assertEquals(10, result[i++]);
    }

    @Test
    public void testSortWithDuplicates(){
        Comparable[] list = new Comparable[] {7, 7, 3, 4, 3, 1, 7};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(1, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(4, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(7, result[i++]);
    }

    @Test
    public void testLargeSet(){
        Comparable[] expected = new Comparable[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000};
        Comparable[] list = new Comparable[]     {515, 324, 359, 838, 737, 864, 8, 148, 551, 46, 898, 726, 466, 664, 406, 673, 101, 78, 175, 335, 529, 187, 289, 887, 127, 396, 185, 428, 665, 854, 946, 137, 41, 258, 917, 829, 45, 76, 512, 988, 662, 772, 464, 325, 275, 57, 744, 319, 810, 767, 725, 377, 1000, 955, 595, 281, 956, 735, 850, 846, 621, 984, 761, 468, 305, 340, 597, 996, 203, 823, 286, 669, 519, 353, 99, 582, 282, 612, 753, 431, 337, 952, 949, 608, 100, 989, 790, 217, 463, 509, 170, 13, 674, 117, 685, 531, 37, 113, 856, 881, 58, 762, 706, 774, 760, 973, 413, 194, 897, 960, 180, 601, 459, 145, 549, 138, 149, 351, 38, 12, 262, 717, 866, 128, 526, 926, 488, 807, 969, 326, 181, 528, 626, 683, 920, 462, 574, 11, 912, 268, 188, 471, 271, 518, 720, 638, 902, 261, 633, 936, 651, 715, 67, 824, 119, 656, 622, 632, 479, 999, 458, 292, 659, 238, 607, 345, 815, 704, 294, 358, 768, 746, 450, 727, 872, 140, 691, 591, 19, 703, 216, 953, 545, 506, 460, 388, 160, 592, 49, 135, 847, 310, 803, 863, 308, 950, 561, 85, 748, 208, 568, 875, 585, 680, 433, 453, 440, 280, 541, 771, 421, 255, 365, 619, 84, 408, 490, 173, 124, 778, 934, 456, 156, 278, 435, 470, 942, 423, 711, 553, 816, 739, 288, 611, 750, 964, 266, 33, 983, 82, 853, 116, 179, 640, 730, 107, 517, 457, 257, 451, 540, 547, 752, 301, 635, 437, 700, 191, 681, 814, 776, 617, 586, 103, 676, 594, 738, 684, 557, 224, 247, 533, 990, 832, 914, 449, 668, 801, 171, 525, 198, 327, 461, 3, 229, 455, 472, 61, 639, 618, 922, 578, 429, 334, 714, 605, 199, 975, 718, 500, 604, 344, 986, 780, 877, 670, 702, 14, 995, 54, 201, 106, 560, 728, 911, 977, 763, 678, 445, 172, 507, 392, 537, 220, 272, 538, 260, 759, 223, 212, 648, 588, 661, 109, 882, 570, 487, 1, 697, 157, 799, 295, 729, 795, 504, 641, 589, 154, 47, 495, 75, 913, 826, 338, 867, 840, 690, 849, 318, 909, 848, 352, 723, 941, 861, 405, 820, 277, 20, 398, 115, 742, 263, 965, 573, 15, 267, 781, 252, 842, 105, 293, 126, 992, 59, 91, 880, 4, 234, 372, 130, 236, 654, 133, 890, 87, 918, 235, 855, 215, 712, 822, 90, 555, 246, 593, 623, 834, 804, 791, 885, 841, 491, 182, 951, 831, 404, 204, 249, 497, 418, 692, 417, 747, 27, 554, 434, 18, 534, 369, 708, 769, 513, 569, 590, 819, 830, 347, 891, 532, 784, 873, 9, 565, 535, 485, 245, 264, 962, 963, 947, 34, 764, 751, 83, 309, 382, 782, 190, 544, 736, 615, 17, 968, 888, 631, 121, 253, 202, 924, 422, 851, 297, 600, 563, 32, 797, 933, 48, 609, 129, 970, 644, 43, 150, 722, 556, 207, 111, 108, 859, 707, 81, 354, 65, 788, 978, 660, 931, 480, 498, 62, 634, 796, 162, 915, 779, 938, 88, 652, 766, 291, 839, 679, 505, 501, 581, 756, 134, 227, 754, 290, 945, 312, 649, 231, 374, 390, 546, 610, 414, 755, 379, 339, 136, 904, 629, 940, 613, 865, 158, 899, 242, 411, 64, 559, 550, 671, 954, 39, 407, 857, 812, 120, 25, 243, 757, 225, 836, 663, 276, 112, 542, 657, 492, 645, 89, 800, 777, 827, 329, 658, 273, 296, 386, 254, 596, 401, 432, 205, 95, 732, 481, 994, 40, 183, 193, 895, 925, 430, 698, 858, 696, 584, 159, 944, 132, 705, 23, 363, 957, 214, 894, 256, 536, 562, 646, 341, 427, 349, 889, 932, 232, 489, 346, 230, 332, 298, 465, 330, 164, 694, 368, 94, 892, 579, 937, 765, 287, 36, 628, 508, 843, 283, 576, 896, 484, 42, 206, 118, 482, 655, 123, 903, 985, 86, 614, 436, 284, 741, 348, 397, 860, 971, 250, 572, 930, 787, 906, 886, 146, 907, 845, 389, 972, 302, 306, 687, 443, 425, 300, 35, 473, 966, 336, 522, 967, 806, 883, 701, 10, 387, 884, 210, 221, 400, 73, 901, 981, 26, 30, 991, 598, 446, 77, 356, 879, 228, 548, 444, 209, 695, 380, 321, 677, 316, 979, 943, 303, 929, 939, 307, 740, 74, 502, 514, 197, 125, 410, 580, 948, 439, 731, 719, 314, 360, 24, 93, 31, 96, 900, 44, 475, 647, 68, 575, 142, 226, 510, 474, 402, 313, 993, 876, 743, 749, 415, 384, 218, 370, 770, 375, 928, 151, 79, 734, 72, 114, 905, 328, 441, 373, 376, 69, 699, 200, 566, 602, 177, 265, 775, 716, 239, 53, 817, 63, 66, 862, 837, 477, 391, 808, 998, 248, 825, 558, 311, 152, 958, 244, 147, 97, 383, 682, 577, 927, 789, 269, 92, 409, 910, 29, 982, 793, 395, 642, 315, 745, 447, 419, 110, 794, 809, 798, 530, 51, 333, 713, 139, 606, 893, 355, 786, 240, 672, 650, 783, 361, 496, 916, 467, 251, 6, 189, 868, 620, 16, 486, 102, 564, 785, 653, 161, 997, 178, 192, 709, 874, 987, 22, 71, 163, 5, 426, 323, 935, 571, 331, 835, 627, 494, 233, 104, 599, 174, 587, 818, 60, 219, 195, 21, 833, 643, 52, 686, 693, 165, 869, 980, 144, 317, 624, 552, 393, 98, 50, 773, 974, 385, 2, 758, 176, 122, 802, 381, 921, 523, 366, 241, 483, 322, 213, 7, 371, 724, 438, 476, 625, 424, 520, 80, 666, 539, 186, 153, 399, 285, 143, 403, 511, 583, 56, 222, 567, 870, 184, 478, 166, 131, 961, 821, 469, 721, 70, 636, 516, 364, 378, 813, 167, 499, 616, 871, 805, 270, 688, 637, 452, 367, 394, 55, 259, 442, 28, 155, 274, 675, 811, 852, 527, 342, 503, 168, 357, 304, 828, 710, 237, 878, 493, 543, 630, 689, 350, 320, 279, 211, 412, 362, 603, 959, 521, 792, 448, 524, 844, 420, 919, 733, 299, 667, 976, 196, 416, 169, 908, 454, 343, 141, 923};
        Comparable[] result = getSorter().sort(list);

        for (int i=0; i<expected.length; i++){
            if (!(expected[i].compareTo(result[i]) == 0)){
                fail("Item " + i + " was out of expected order");
            }
        }
    }

    @Test
    @Ignore
    public void testSimpleStability(){
        assumeThat(isStable(), is(true));

        //     sorts need to be generisized so that a sort() will return the same type passed to it and not Comparable[]
        SortableClass a1 = new SortableClass("Ross", 36);
        SortableClass a2 = new SortableClass("Drew", 36);

        SortableClass[] list = new SortableClass[] {a1, a2};
        //SortableClass[] result = getSorter().sort(list);
    }

    public class SortableClass implements Comparable<SortableClass>{
        private final Integer age;
        private final String name;

        public Integer getAge() {
            return age;
        }

        public SortableClass(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(SortableClass o) {
            return age.compareTo(o.getAge());
        }
    }
}
