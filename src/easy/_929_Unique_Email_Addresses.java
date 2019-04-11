package easy;

public class _929_Unique_Email_Addresses {
	public static int numUniqueEmails(String[] emails) {
		int l = emails.length;
		for (int i = 0; i < l; i++) {
			String[] name = emails[i].split("@");
			char[] carr = name[0].toCharArray();
			String lcn = "";
			for (char temp1 : carr) {
				if (temp1 == '.') {
					continue;
				}
				if (temp1 == '+') {
					break;
				}
				lcn = lcn + temp1;
			}
			System.out.println(lcn + "@" + name[1]);
			emails[i] = lcn + "@" + name[1];
		}
		int size = 0;
		String[] com = new String[l];
		for (int i = 0; i < l; i++) {
			boolean flag = false;
			for (int j = 0; j < size; j++) {
				if (emails[i].equals(com[j])) {
					flag = true;
				}
			}
			if (!flag) {
				com[size++] = emails[i];
			}
		}
		return size;
	}

	public static void main(String[] args) {
//		String[] t = new String[3];
//		t[0]="test.email+alex@leetcode.com";
//		t[1]="test.e.mail+bob.cathy@leetcode.com";
//		t[2]="testemail+david@lee.tcode.com";
//		String[] name = t[0].split("@");
		String[] name = { "fg.r.u.uzj+o.pw@kziczvh.com", "r.cyo.g+d.h+b.ja@tgsg.z.com", "fg.r.u.uzj+o.f.d@kziczvh.com",
				"r.cyo.g+ng.r.iq@tgsg.z.com", "fg.r.u.uzj+lp.k@kziczvh.com", "r.cyo.g+n.h.e+n.g@tgsg.z.com",
				"fg.r.u.uzj+k+p.j@kziczvh.com", "fg.r.u.uzj+w.y+b@kziczvh.com", "r.cyo.g+x+d.c+f.t@tgsg.z.com",
				"r.cyo.g+x+t.y.l.i@tgsg.z.com", "r.cyo.g+brxxi@tgsg.z.com", "r.cyo.g+z+dr.k.u@tgsg.z.com",
				"r.cyo.g+d+l.c.n+g@tgsg.z.com", "fg.r.u.uzj+vq.o@kziczvh.com", "fg.r.u.uzj+uzq@kziczvh.com",
				"fg.r.u.uzj+mvz@kziczvh.com", "fg.r.u.uzj+taj@kziczvh.com", "fg.r.u.uzj+fek@kziczvh.com" };

		System.out.println(numUniqueEmails(name));
//		String[] lcname = ts.split(".");
//		System.out.println(t[0].split(".")[0]);
//		System.out.println(numUniqueEmails(t));
	}
}
