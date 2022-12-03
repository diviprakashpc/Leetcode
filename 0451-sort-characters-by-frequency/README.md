<h2><a href="https://leetcode.com/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a></h2><h3>Medium</h3><hr><div><p><font _mstmutation="1" _msthash="3617380" _msttexthash="13529828">Given a string , sort it in <strong _mstmutation="1">decreasing order</strong> based on the <strong _mstmutation="1">frequency</strong> of the characters. The <strong _mstmutation="1">frequency</strong> of a character is the number of times it appears in the string.</font><code>s</code></p>

<p _msthash="3617497" _msttexthash="3350932">Return <em>the sorted string</em>. If there are multiple answers, return <em>any of them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example" _msthash="3617731" _msttexthash="114439">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "tree"
<strong>Output:</strong> "eert"
<strong>Explanation:</strong> 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
</pre>

<p><strong class="example" _msthash="3617965" _msttexthash="114621">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cccaaa"
<strong>Output:</strong> "aaaccc"
<strong>Explanation:</strong> Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
</pre>

<p><strong class="example" _msthash="3618199" _msttexthash="114803">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "Aabb"
<strong>Output:</strong> "bbAa"
<strong>Explanation:</strong> "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
</pre>

<p>&nbsp;</p>
<p><strong _msthash="3703453" _msttexthash="199901">Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>s</code><font _mstmutation="1" _msthash="4265443" _msttexthash="2542579"> consists of uppercase and lowercase English letters and digits.</font></li>
</ul>
</div>