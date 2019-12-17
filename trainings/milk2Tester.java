
//
// import java.io.*;
// import java.util.ArrayList;
// import java.util.StringTokenizer;
// import java.util.Collections;
// class milk implements Comparable<milk>
// {
// private int start;
// private int end;
// public milk(int start, int end)
// {
// this.start = start;
// this.end = end;
// }
// public int getStart()
// {
// return start;
// }
// public int getEnd()
// {
// return end;
// }
//
// public int compareTo(milk other) {
// if (other.getStart() > start)
// {
// return -1;
// }
// else if (other.getStart() < start)
// {
// return 1;
// }
// else
// {
// return 0;
// }
//
// }
// public boolean isCont(milk other)
// {
// if (end >= other.getStart())
// {
// return true;
// }
// return false;
// }
// public String toString()
// {
// return start + ", " + end;
// }
// }
// public class milk2Tester {
//
// public static void main(String[] args) throws IOException
//
// {
// BufferedReader fin = new BufferedReader(new FileReader("milk2.in"));
// PrintWriter fout = new PrintWriter(new BufferedWriter(new
// FileWriter("milk2.out")));
// ArrayList<milk> list = new ArrayList<milk>();
// fin.readLine();
// String input = null;
// while (!(input = fin.readLine()).equals("quit"))
// {
// String[] nums = input.split(" ");
// list.add( new milk(Integer.parseInt(nums[0]),Integer.parseInt(nums[1])));
// }
// Collections.sort(list);
// int cont = getCont(list);
// int dis = getDis(list);
// fout.println(cont + " " + dis);
// fin.close();
// fout.close();
//
//
//
// }
// //this method assumes the list is sorted
// public static int getCont(ArrayList<milk> list)
// {
// int most = -1;
// for (int i = 0; i < list.size(); i++)
// {
// milk start = list.get(i);
// int beg = start.getStart();
// int end = start.getEnd();
// int cont = end - beg;
// for (int j = i + 1; j < list.size();j++)
// {
//
// milk next = list.get(j);
// if (start.isCont(next))
// {
//
// if (next.getEnd() - beg > cont)
// {
// cont = next.getEnd() - beg;
//
// }
// start = next;
// continue;
// }
// break;
// }
// if (cont > most)
// {
// most = cont;
// }
// }
// return most;
// }
// public static int getDis(ArrayList<milk> list)
// {
// int most = -1;
// for (int i = 0; i < list.size(); i++)
// {
// milk start = list.get(i);
// int beg = start.getStart();
// int end = start.getEnd();
// int dis = 0;
// for (int j = i + 1; j < list.size();j++)
// {
// milk next = list.get(j);
// if (start.isCont(next))
// {
// start = next;
// continue;
// }
// dis = next.getStart() - list.get(j-1).getEnd();
// }
// if (dis > most)
// {
// most = dis;
// }
// }
// return most;
//
// }
// }
