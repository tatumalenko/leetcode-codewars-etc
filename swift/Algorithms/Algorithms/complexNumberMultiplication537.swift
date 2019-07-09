//
//  complexNumberMultiply537.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

func complexNumberMultiply537(_ a: String, _ b: String) -> String {
    func splitComplexToReIm(_ complexNumber: String) -> (Int, Int) {
        let splited = complexNumber.components(separatedBy: "+")
        return (Int(splited[0]) ?? 0, Int(splited[1].dropLast()) ?? 0)
    }
    let (aRe, aIm) = splitComplexToReIm(a)
    let (bRe, bIm) = splitComplexToReIm(b)
    let cRe = aRe * bRe - aIm * bIm
    let cIm = aRe * bIm + aIm * bRe
    return "\(cRe)+\(cIm)i"
}

func complexNumberMultiplication537() {
    assert(complexNumberMultiply537("1+1i", "1+1i") == "0+2i")
    assert(complexNumberMultiply537("1+-1i", "1+-1i") == "0+-2i")
}
