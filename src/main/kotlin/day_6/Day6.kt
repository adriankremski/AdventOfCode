package day_6

val day6Data = """
    stftmtvvtvqqczqqnjnwwlqqdzdnnsvnsswbbwsstvvssfjsjbjfjmjpjzpplpppjzjqqdzzhqqqqtcccbzzzwzrrrdqdldpdsppmqmmnwwjddnqqscclncllvhllqpllchhbccfcbcgbcgcfcncsnstsddldzldlmljjfbjbzbccmrmrppqmqsswbwqwdwwcnwwhrhppfsfvsvrrfllhglhlggjpggzjgzggnvvqfvvhffpwpmwpmmwvmvrmrbmbzmzbbvgbbcfbcfbfppnzpzrrszzqgzgjgddmdwmwrmwmzznqzqhqhvvsslppsrrljjfpfcpfpbbrjjwjmjpmpfmfzfvzfftptzzbmzmddpvdddqmmzjzbbhmmwqmmmbgmmttrhrqrvqvzvdvzdvvmsvmmqlmmtddvlvttrtvtvcttvssnwwbccqmmgbbqrqlqjllmslsmslltrtffzfpfzpffvwvffsllgvgtgwtwnttfzznzqzztfzfvzznnwzzcvcqvvdwwsnsvnnthhnphpssmjmfmhfmhmgmllmsmrsrrmmhsswjwqqdbbghhpsptsswvsvfvcffqcchlhfhvhjhdjhddvjjpmmsrsqrrngrrmvmsvsllrmlrlprpggqzqmmvlvvwrwnrwwzztrzrbrdbrdbbhlhchjchhtthpthphplhhlphpjjsddtppvbpbbmnmgnmmqbbrhhfrfpfjpjgjljcctwtmwtwvvvmsvmmnjmnjmnmqmvvggtzzctzttszsvvjwjqjmjbjvbbshbhghlghhpvpnvvqmmgjmmggqvqtvqtvqtvvmlljbbhdhshnnwqwbbrnnwswmwfmfttjztjzjsjzjdjbdjjzfzdzgzhghgpgqqdzdhhnwnjnnhrnrqqjsqsllbzzzcnzzmjmvmrvrgrfgrrqmrmpmpzmzqqfwqfwfjjhphgpptzzwmmfjjvbjvbbqsbsbcbppjzpjjzpjpvjjzdjjgcgppvrvjrjpjspjppntpnnjlnlrnrdndjnnsbnnppvspprbrddjrdrmrfmmtmtbtntftjjsscvcbvvcnccnbnrbbmlmddhpdptddmrmmjddnjjtztctqqhhttqctqtbbnfnwnmndnzzljlgltgltljtjllwjjbrjbrbpbgppmzpmpggdnnmznnhhmfhhssgtgvvlsljltlppdqqbtbvbsvsswbsbhsbsmmwswbbbbhvbvcbvvsvcsvvmfmlmgmjgmmbqbrbsrrgrsggldlmlttpbpmmtptctqcqvccnhnmnssmvsmmddlclpccfwfdfqfvqfvfqqwmmwrmmbzznpnllfttgcttnbtnnsswttfppnddpdpsphhpttnrtrlrsrmrnmmzhmhnmnwwddmhdhqqhbqqdcclnlfnnzfnzzqfqddczcqcrrjsrrswslltfltffjhhqqfcchqcqpplbltbblbcbncnpccdffcwwqzwqqlwwtjjpbbjvvljvjgvvrsszfsfcssqsvvwsvvdfvdfdpffztzrtzthzhhmwmzwzssjlsldsldsldlvvjdvvnbvnvmvmccvfcvcfcbchhzqqhgqqcbbhdbdpddwcdwwzszsfszzgbgdgzgvgsgnssfqsqjssrppsgppmmpzmppglgqlqqpzpqqfzzzrnzrnrqqzzfwzzffjfzzmnznpznpprhhvcvvvfddcrdrsscnnsznzszbznntwntnrnbnzzrnnlwlggnzzwppmbmrrncnlclzltlblhhlvhvphhsdhsdsqddgzgvvshvvzzbvbrrlplqpptplljcljlvjlvlqvvndnsdddmvddzhzjjgpjpddppzllwtwfwgfgpffmhhzllsttmqqhjhhpvpgpfjsgscnwjmwmtmptwlpfjljwgpgntrlpjfgbjqmcpzgfhrwmznqnsbpptbdrzmdtvvtdqjgrjzlphndhmlchvddglqnqsjqrfqslprsvlqjwqnsmsznptsstpvdntpttslpmqqbsdlqwpjqnzmpblgqmjrvqwsncnzdszgfsghddlnwhwzpgtddgstttvrjfjwwfrgsdjjngljqlqcrzlgsmwngbzvmjwtnqdqcgwmfhsztgrtvvfzbtstmdbqpntdpsszjthqvpbdwswfzvmrcpbgbgdmldfhvdpfsmdzfhwsrpcglsztdwqgbqszcqtqjhgntzvttldqsffftzmllptzhmhpmfsgcchfrnrchnsgcfjbgrqmvrmmhnmlnwtgwhznqfgwnlrqlpjrvfrgzcjwncvlwhpclfzngbgvmrmlzngmqlvvwhbpjzlclgrcnnvnlppqhvlrnpzvmtsbdpfbwgffgzfwvltcfvfdcnfhwvcvclwwbmshhmpgrzgltwjmqczpqzdwfjpqhmwqhvvgnpgtwrjrgwvhthtdrdpnwpbmwstgblwmbfvlwflqmfbcsgwstwvncwfcsmrpcfrrvmlbqhdtdswswfnzhgzlngwsrtlzfcgdppmjnghfrgbdqhqmslhcqddjvsslsjwqqznttqjzdlghnsvqqtwrpfbzjgwnrhhvlnbqmnvcpblzgbzltnrhzpdwvbqbtmctbzgsdjfzswrbqbzgvwjlwtmgcllnmnwcljbhbplpvtgpgjftfrbgpgmhghnjcgjfqmsbqhbgtzbfzgwmfdsgfgmgzsbgdrszfhjttbvcqjzjgbqfgswlmrrhnmnfrptvjtlnvplgznsljzfzmhghlsccnqzflfnmbhshfprhclmtfptcmtnhrjgnngnqnczvcgzzlntftjsbgpgwzbnrhzzfqmznqnzfrvjzsmtpjbswzjlbgpfftzrzbfgdblpwscbqjfrfmfnhhlhjprtlzzvwnwzsnqhnmgwsdprnrblgbclzhthftqzdljspwdzwmwhfmdzmlvqsngppdfsjdprbrhffcvcvzztjjqcffwbrvpzvzfzhjvsfvsnrmjvqmjtrjbmbqsdtjgvtbbzzfmnmrrflgcdtljpmpvqvdbzgbmhjgccgdtplllctzqpfqnsztbwdbmqgfzrcddtmwrgmwsghcfpgqssdjrtqhtjfbpjvjdnzgvpzrhbrhrhcmpbglbbrvdltdpsrwjbjzftccwgnqmnlqlpjwrfdvmlgvgqznlvsmpzsmgjstvqbqpprzlsdndpfbmqcrfgvcfvlfhmpfnnqlcqlnbbgcrrrhbtzwnwmfrnrzvgmqlmqnmnzbwflwzcmncphjqztlrzvpztqhptmfsrppvvlzcfnlrwptgccsjjjscjcwnzssmbcvtzhnscgsbrchbqbrtdzllfvmqfwznfzpzmbfwcdsfhdlddnfbdgqbqjqzdtppshwcvvcjqstdgtgbhmlqlrfrhbvfsszsmbldmwfnfgnjptdslnzwcjgmvbnqcfzjmrslrlllplbhpjcnvzmvrfzwqhmbnrvpqnvcfncgfwqlvcwpwwljssfmswctcmhgtphvjdpfnnzznfbdjcsndrczlgdjhrnrltsgbtqmqcbwlthwcgsbvqbnntcznczpmlmblwdrlmzqdztwsgjthjwtfcpgwbczmdmhttzcwvdzhdfldmwnbnfdcjgvjhrfltjnjhqhzmzrlbncwdnlgshmqhpgsdwbvmvjsfgvgqzqjqdzqzmfmrncfdgrqfrnstvpqwtltnhgrmhgmmnwvlnsfmmbjrdmrnlgfgpqncdpqgvjltpghbgffdppdcfhdqhtvrdnfvcttlrqppfnqtmzpfgsnmjqfrgtbbdzzrccsrzgfjndlrnzqmjjtgldglcpzcrhwfplvdndjtzbpfbbbpfljqnlvrdzbrvczzwdrvzlmslbjsqgqdrltmhwcdpldqldlpctcbjmsvdwlfspzlpgrhdrvjtprcwrmszvzwmmjgvsbfcztmrdgrgshgtggpzszgqhwmhdzjmzsgqsfmqvcgqqwgprgvvqlbfhpwsfbjdqtcfnfhsgzthzhbpwggbnscqbnvcdprsbgllsrdcclqggfgfdrpqlqljfwpmzdhthpczcsqrrm
""".trimIndent()

fun day6() {
    println(day6Data.findStartOfSequence(4))
}

fun day6Part2() {
    println(day6Data.findStartOfSequence(14))
}

fun String.findStartOfSequence(messageLength: Int) = windowed(messageLength)
    .indexOfFirst { text ->
        text.toSet().size == messageLength
    } + messageLength