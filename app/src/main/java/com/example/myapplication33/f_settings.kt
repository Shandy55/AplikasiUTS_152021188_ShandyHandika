package com.example.myapplication33

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [f_settings.newInstance] factory method to
 * create an instance of this fragment.
 */
class f_settings : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    fun goToSettingsFragment(view: View) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Menghapus semua transaksi fragment sebelumnya dari tumpukan kembali
        fragmentManager.popBackStack("myBackStackTransactionName", FragmentManager.POP_BACK_STACK_INCLUSIVE)

        // Kemudian, Anda menambahkan transaksi fragment baru
        val setfrag = f_settings.newInstance("param1", "param2")
        fragmentTransaction.replace(R.id.f_container, setfrag)
        fragmentTransaction.addToBackStack("myBackStackTransactionName")
        fragmentTransaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        var settingsview : View = inflater.inflate(R.layout.fragment_f_settings, container, false)
        var btn = settingsview.findViewById<Button>(R.id.editprof)
        btn.setOnClickListener {
            val intent = Intent(requireContext(), Edit_profile::class.java)
            startActivity(intent)
        }
        var btnkeluar = settingsview.findViewById<Button>(R.id.exit)
        btnkeluar.setOnClickListener {
            showLogoutConfirmationDialog()

        }

        return settingsview
    }
    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Logout")
        builder.setMessage("Anda yakin ingin logout?")

        // Tombol positif (ya)
        builder.setPositiveButton("Ya") { dialog, which ->
            // Tambahkan kode logout di sini
            // Contoh: Keluar dari sesi pengguna, hapus token akses, dll.
            performLogout()
        }

        // Tombol negatif (batal)
        builder.setNegativeButton("Batal") { dialog, which ->
            // Batal logout, tutup dialog
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun performLogout() {
        // Tambahkan logika logout di sini
        // Contoh: Keluar dari sesi pengguna, hapus token akses, dll.
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment f_settings.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f_settings().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}